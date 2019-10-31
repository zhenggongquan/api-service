package com.api.apiservice.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author John
 **/
public class FtpDataPushProvider {
    private static final Logger logger = LoggerFactory.getLogger(FtpDataPushProvider.class);
    private static final String FINISH_FILE_NAME = "finish";

//    @Value("${shandong.upload.ip}")
//    private String ip;
//    @Value("${shandong.upload.port}")
//    private int port;
//    @Value("${shandong.upload.username}")
//    private String username;
//    @Value("${shandong.upload.password}")
//    private String password;

    public static void doUpLoadFile(String company, List<String> filepaths, String ip, int port,
                                    String username, String password) throws Exception {
        logger.info("ftp-data-push-provider: --- start ---");
        boolean flag = true;
        InputStream in = null;
        FTPClient ftpClient = null;
        String file2 = null;
        String file3 = null;
        List<String> allFileNames = new ArrayList<String>();
        //连接ftp并创建目录
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        try {
            ftpClient.connect(ip, port);
            ftpClient.enterLocalPassiveMode();//被动模式
            ftpClient.login(username, password);
            int replyCode = ftpClient.getReplyCode();
            if (FTPReply.isPositiveCompletion(replyCode)) {
                file2 = new SimpleDateFormat("yyyyMM").format(new Date());
                file3 = new SimpleDateFormat("dd").format(new Date());
                logger.info("-FTP上传开始");
                ftpClient.changeWorkingDirectory("~");
                //\国药控股山东有限公司\201910\28\xxx.csv
                String path = "\\" + company + "\\" + file2 + "\\" + file3 + "\\";
                boolean shandong = ftpClient.makeDirectory(company);
                boolean shandongFlag = ftpClient.changeWorkingDirectory(company);
                boolean yearMonth = ftpClient.makeDirectory(file2);
                boolean yearMonthFlag = ftpClient.changeWorkingDirectory(file2);
                boolean day = ftpClient.makeDirectory(file3);
                boolean dayFlag = ftpClient.changeWorkingDirectory(file3);
                logger.info("创建目录 change-dir:" + path);
                if (filepaths.size() > 0 && dayFlag) {
                    boolean pushFlag = true;
                    for (String tempFileName : filepaths) {
                        if (null != in) {
                            in.close();
                        }
                        logger.info("临时文件:" + tempFileName);
                        if (pushFlag) {
                            in = new FileInputStream(tempFileName);
                            ftpClient.setBufferSize(32);
                            int startIndex = tempFileName.lastIndexOf("\\");
                            pushFlag = ftpClient.storeFile(tempFileName.substring(startIndex + 1, tempFileName.length()), in);
                            logger.info("{} 上传至FTP标识: {}", tempFileName, pushFlag);
                            in.close();
                            in = null;
                        }
                        flag = pushFlag;
                    }
                    for (String tempFileName : filepaths) {
                        File file0 = new File(tempFileName);
                        boolean deleteFlag = file0.delete();
                        logger.info("删除临时文件:{} 标识：{}", tempFileName, deleteFlag);
                    }
                }
            } else {
                logger.info("ftp登陆失败");
                flag = false;
                ftpClient.disconnect();
                throw new Exception("ftp登陆失败");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            flag = false;
            throw e;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("FTP上传完成标识:----------------------- {}", flag);
        //回写finish flag
        if (flag) {
            finishStatusToFTP(company, file2, file3, ip, port, username, password);
            logger.info("FTP上传结束");
        }
    }

    public static void finishStatusToFTP(String company, String file2Path, String file3Path, String ip, int port,
                                         String username, String password) throws Exception {
        logger.info("ftp-data-后续处理 --- start ---");
        FTPClient ftpClient = null;
        //连接ftp并创建目录
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        try {
            ftpClient.connect(ip, port);
            ftpClient.enterLocalPassiveMode();
            ftpClient.login(username, password);
            int replyCode = ftpClient.getReplyCode();
            if (FTPReply.isPositiveCompletion(replyCode)) {
                ftpClient.changeWorkingDirectory("~");
                boolean shandong = ftpClient.makeDirectory(company);
                boolean shandongFlag = ftpClient.changeWorkingDirectory(company);
                boolean yearMonth = ftpClient.makeDirectory(file2Path);
                boolean yearMonthFlag = ftpClient.changeWorkingDirectory(file2Path);
                boolean day = ftpClient.makeDirectory(file3Path);
                boolean dayFlag = ftpClient.changeWorkingDirectory(file3Path);
                if (dayFlag) {
                    try {
                        FTPFile[] files =ftpClient.listFiles("finish");
                        if(files.length == 0){
                            ftpClient.storeFile("finish", new FileInputStream("finish"));
                        }
                    }catch (Exception ex){
                        logger.error("忽略...");
                    }
                }
            } else {
                logger.info("ftp登陆失败");
                ftpClient.disconnect();
                throw new Exception("ftp登陆失败");
            }
        } catch (Exception e) {
            logger.error("生成finish文件出错,{}", e.getMessage());
            throw e;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //回写finish flag
        logger.info("FTP上传回写finish结束");
    }

//    public static void main(String[] args) throws Exception {
//        finishStatusToFTP("国药控股山东有限公司","201910","29","180.169.118.244",21,"guoyaokonggushandong","8iLK96");
//    }

}