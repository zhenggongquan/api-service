package com.api.apiservice.gkah.http;

import com.api.apiservice.util.CsvUtil;
import com.api.apiservice.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * @author John
 **/
@Component
public class AnhuiApiTask {

    @Value("${anhuiguokong.host}")
    private String url;
    @Value("${anhuiguokong.token}")
    private String token;
    @Value("${anhuiguokong.userid}")
    private String userid;
    @Value("${anhuiguokong.password}")
    private String password;
    @Value("${anhuiguokong.private-key}")
    private String privateKey;

//    @Value("${anhuiguokong.upload.ip}")
//    private String uploadIp;
//    @Value("${anhuiguokong.upload.port}")
//    private int uploadPort;
//    @Value("${anhuiguokong.upload.username}")
//    private String uploadUsername;
//    @Value("${anhuiguokong.upload.password}")
//    private String uploadPassword;

    private static final Logger logger = LoggerFactory.getLogger(AnhuiApiTask.class);

    /**
     * 采购  销售 入库 上传
     * @param endDate
     * @return
     */
//    @Scheduled(cron = "0 30 01 * * ? ")
    public String upLoadFile(String endDate) {
        List<String> filePaths = new ArrayList<>(2);
        try {
            if (StringUtils.isEmpty(endDate)) {
                endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());  //当前时间
            }
            String filepath1 = generationPurData(endDate);
//            Thread.sleep(19000);
//            String filepath2 = generationDataSaleData(endDate);
//            String filepath3 = generationStockInData(endDate);
            filePaths.add(filepath1);
//            filePaths.add(filepath3);
        } catch (Exception ex) {
            logger.error("生成文件报错！{},{}", ex, ex.getMessage());
            return "生成文件报错!";
        }
        try {
//            FtpDataPushProvider.doUpLoadFile(Constants.COMPANY_SHANDONGGUOYAO, filePaths,
//                    uploadIp, uploadPort, uploadUsername, uploadPassword);
        } catch (Exception e) {
            logger.error("上传文件报错！{},{}", e, e.getMessage());
            return "上传文件报错!";
        }
        return "OK!";
    }


    /**
     * 销售销售上传
     *
     * @param endDate
     * @return
     */
//    public String uploadSale(String endDate) {
//        List<String> filePaths = new ArrayList<>(3);
//        try {
//            if (StringUtils.isEmpty(endDate)) {
//                endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());  //当前时间
//            }
//            String filepath2 = generationDataSaleData(endDate);
//            filePaths.add(filepath2);
//        } catch (Exception ex) {
//            logger.error("生成文件报错！{},{}", ex, ex.getMessage());
//            return "生成文件报错!";
//        }
//        try {
//            FtpDataPushProvider.doUpLoadFile(Constants.COMPANY_SHANDONGGUOYAO, filePaths,
//                    uploadIp, uploadPort, uploadUsername, uploadPassword);
//        } catch (Exception e) {
//            logger.error("上传文件报错！{},{}", e, e.getMessage());
//            return "上传文件报错!";
//        }
//        return "OK!";
//    }

    /**
     * 采购
     * @return
     * @throws Exception
     * @Scheduled
     */
    public String generationPurData(String formatDate) throws Exception {
        //todo ......
        String startDate = formatDate;
        String endDate =  DateUtil.conventFormatDate(formatDate,DateUtil.dateFormatter1,90, DateUtil.dateFormatter2);
        logger.info("计算到的开始日期为：{}, 结束日期为: {}", startDate, endDate);
        List<List> records = new ArrayList();
        String fileName = "采购单";
        String filedir = "anhuiguo";
        String[] arrays = {"序号", "采购单号", "采购日期", "订单类型", "供应商编码", "供应商名称", "产品编码", "产品名称",
                "产品规格", "产品单位", "生产厂家", "产品批号", "有效期", "购进数量", "购进单价", "购进金额",
                "仓库名称", "货主名称", "经销商平台", "经销商编号"};
        List<String> Headers = new ArrayList<>(Arrays.asList(arrays));
        int currentPage = 1;
        File file = null;
        try {
//            do {
                records = PurchaseApi.getPurData(url , privateKey,  token, userid, password, startDate, endDate);
//                if (currentPage == 1) {
//                    file = CsvUtil.makeTempCSV(filedir, fileName, Headers, records);
//                } else {
//                    CsvUtil.appendFileCsv(file.getAbsoluteFile(), records);
//                }
//                currentPage++;

//            } while (records != null && records.size() == 200);
            return file.getAbsolutePath();
        } catch (Exception e) {
            logger.error("采购数据出错！");
            throw e;
        }
    }


    /***
     *
     * 销售数据
     * @return
     * @throws Exception
     */
    public String generationDataSaleData(String formatDate) throws Exception {
        String startDate = formatDate;
        String endDate =  DateUtil.conventFormatDate(formatDate,DateUtil.dateFormatter1,90, DateUtil.dateFormatter2);
        logger.info("计算到的开始日期为：{}, 结束日期为: {}", startDate, endDate);
        List<List> records = new ArrayList();
        String fileName = "销售单";
        String fileDir = "";
        String[] arrays = {"序号", "销售单号", "开单日期", "出库复核日期", "订单类型", "客户编码", "客户名称", "客户地址编号",
                "客户地址", "产品编码", "产品名称", "产品规格", "产品单位", "生产厂家", "产品批号", "有效期至",
                "销售数量", "销售单价", "销售金额", "原供货商编码", "原供货商名称", "仓库名称", "货主名称", "批次号", "经销商平台", "经销商编号"};
        List<String> Headers = new ArrayList<>(Arrays.asList(arrays));
        int currentPage = 1;
        File file = null;
        try {
//            do {
                records = PurchaseApi.getSaleData(url , privateKey,
                          token, userid, password, startDate, endDate);
//                if (currentPage == 1 && records != null && !records.isEmpty()) {
//                    file = CsvUtil.makeTempCSV(fileDir, fileName, Headers, records);
//                } else {
//                    CsvUtil.appendFileCsv(file.getAbsoluteFile(), records);
//                }
//                currentPage++;
//            } while (records != null && records.size() == 200);
            return file.getAbsolutePath();
        } catch (Exception e) {
            logger.error("销售数据出错！");
            throw e;
        }

    }


    /***
     *
     * @return 库存数据
     * @throws Exception
     */
    public String generationStockInData(String formatDate) throws Exception {
        String startDate = formatDate;
        String endDate =  DateUtil.conventFormatDate(formatDate,DateUtil.dateFormatter1,90, DateUtil.dateFormatter2);
        logger.info("计算到的开始日期为：{}, 结束日期为: {}", startDate, endDate);
        List<List> records = new ArrayList();
        String fileName = "库存单";
        String fileDir = "";
        String[] arrays = {"序号", "库存日期", "最近一次入库日期", "产品编码", "产品名称", "产品规格", "产品单位", "生产厂家",
                "产品批号", "生产日期", "有效期至", "库存数量", "原供货商编码", "原供货商名称", "仓库名称", "货主名称", "批次号", "经销商平台", "经销商编号"};
        List<String> Headers = new ArrayList<>(Arrays.asList(arrays));
        int currentPage = 1;
        File file = null;
        try {
            do {
                records = PurchaseApi.getStockInData(url, privateKey,
                        token, userid, password, startDate, endDate);
                if (currentPage == 1) {
                    file = CsvUtil.makeTempCSV(fileDir, fileName, Headers, records);
                } else {
                    CsvUtil.appendFileCsv(file.getAbsoluteFile(), records);
                }
                currentPage++;
            } while (records != null && records.size() == 200);
            return file.getAbsolutePath();
        } catch (IOException e) {
            logger.error("库存数据出错！");
            throw e;
        }
    }
}
