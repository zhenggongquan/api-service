package com.api.apiservice.gyyn;

import com.api.apiservice.gyyn.util.CustomMd5;
import com.api.apiservice.gyyn.util.GyYNXMLUtilDoc;
import com.api.apiservice.gyyn.util.GyynHeaderConfig;
import com.api.apiservice.util.Constants;
import com.api.apiservice.util.CsvUtil;
import com.api.apiservice.util.DateUtil;
import com.api.apiservice.util.FtpDataPushProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author John
 **/
@Component
public class GkYnApiTask {
    @Value("${guoyaoyunnan.username}")
    private String username;
    @Value("${guoyaoyunnan.password}")
    private String password;
    @Value("${guoyaoyunnan.pseudoCode}")
    private String pseudoCode;

    @Value("${guoyaoyunnan.upload.ip}")
    private String uploadIp;
    @Value("${guoyaoyunnan.upload.port}")
    private int uploadPort;
    @Value("${guoyaoyunnan.upload.username}")
    private String uploadUsername;
    @Value("${guoyaoyunnan.upload.password}")
    private String uploadPassword;

    private static final Logger logger = LoggerFactory.getLogger(GkYnApiTask.class);

    /**
     * //     * @param username
     * //     * @param password
     *
     * @return
     */
    //    @Scheduled(cron = " 0 / 10 * * * * ? ")
    public String upLoadFile(String formatDate) {
        List<String> filePaths = new ArrayList<>(3);
        try {
            String code = generationCode(username, password);
            System.out.println("加密后返回值：" + code);
            if (StringUtils.isEmpty(formatDate)) {
                formatDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); //当前时间
            }
            String salePath = generationData(username, password, Constants.GYYNCUSTOM_800001, formatDate, code, "公司销售单");
            code = generationCode(username, password);
            String purchasePath = generationData(username, password, Constants.GYYNCUSTOM_800002, formatDate, code, "采购单");
            code = generationCode(username, password);
            String stockPath = generationData(username, password, Constants.GYYNCUSTOM_800003, formatDate, code, "库存单");
            filePaths.add(salePath);
            filePaths.add(purchasePath);
            filePaths.add(stockPath);
        } catch (Exception ex) {
            logger.error("生成文件报错！{},{}", ex, ex.getMessage());
            return "生成文件报错!";
        }
        try {
            FtpDataPushProvider.doUpLoadFile(Constants.COMPANY_GUOYAOYUNNAN, filePaths,
                    uploadIp, uploadPort, uploadUsername, uploadPassword);
        } catch (Exception e) {
            logger.error("上传文件报错！{},{}", e, e.getMessage());
            return "上传文件报错!";
        }
        return "OK!";
    }

    /**
     * 生成 CODE
     *
     * @return
     * @throws Exception
     */
    public String generationCode(String username, String paswd) throws Exception {
        XxdjWebServiceSoap_PortType xxdjWebServiceSoap12Stub = (XxdjWebServiceSoap_PortType) new XxdjWebServiceLocator()
                .getPort(XxdjWebServiceSoap_PortType.class);
        String selectedCode = xxdjWebServiceSoap12Stub.getTempCode(username, paswd);
        System.out.println("返回值：" + selectedCode);
        try {
            return CustomMd5.md5code(selectedCode + pseudoCode);
        } catch (Exception e) {
            logger.error("生成校验码数据出错！{},{}", e, e.getMessage());
            throw e;
        }
    }

    /**
     * @param username
     * @param paswd
     * @param transactionCode
     * @param
     * @param formatDate
     * @param code
     * @return
     * @throws Exception
     */
    public String generationData(String username, String paswd,
                                 String transactionCode, String formatDate, String code, String fileName) throws Exception {
        XxdjWebServiceSoap_PortType xxdjWebServiceSoap12Stub = (XxdjWebServiceSoap_PortType) new XxdjWebServiceLocator()
                .getPort(XxdjWebServiceSoap_PortType.class);
             //一个月一个月取数据
            List<List> records = new ArrayList();
            String endDate = transEndDate(formatDate);
            Date startDate = transStartDate(formatDate);
            formatDate = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
            logger.info(transactionCode+",计算到的开始日期为：{}, 结束日期为: {}",new SimpleDateFormat("yyyyMMdd").format(startDate), endDate);
            String selected30Day1 = xxdjWebServiceSoap12Stub.selected(username, paswd, transactionCode, new SimpleDateFormat("yyyyMMdd").format(startDate), endDate, code);
            Map<String, Object> map1 = GyYNXMLUtilDoc.xmlElements(selected30Day1);
            List<List> lists1 = GyYNXMLUtilDoc.transMap(map1,transactionCode);
            records.addAll(lists1);

            endDate = transEndDate(formatDate);
            startDate = transStartDate(formatDate);
            formatDate = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
            code = generationCode(username, password);
            String selected30Day2 = xxdjWebServiceSoap12Stub.selected(username, paswd, transactionCode, new SimpleDateFormat("yyyyMMdd").format(startDate), endDate, code);
            Map<String, Object> map2= GyYNXMLUtilDoc.xmlElements(selected30Day2);
            List<List> lists2 = GyYNXMLUtilDoc.transMap(map2,transactionCode);
            records.addAll(lists2);

            endDate = transEndDate(formatDate);
            startDate = transStartDate(formatDate);
            code = generationCode(username, password);
            String selected30Day3 = xxdjWebServiceSoap12Stub.selected(username, paswd, transactionCode, new SimpleDateFormat("yyyyMMdd").format(startDate), endDate, code);
            Map<String, Object> map3= GyYNXMLUtilDoc.xmlElements(selected30Day3);
            List<List> lists3 = GyYNXMLUtilDoc.transMap(map3,transactionCode);
            records.addAll(lists3);

        logger.info("计算到的开始日期为：{}, 结束日期为: {}");
        String filedir = "yunnangy";
        String[] arrays = GyynHeaderConfig.hashMap.get(transactionCode);
        try {
            File file = CsvUtil.makeTempCSV(filedir, fileName, new ArrayList(Arrays.asList(arrays)), records);
            return file.getAbsolutePath();
        } catch (IOException e) {
            logger.error("生成数据出错！");
            throw e;
        }
    }

    /**
     * 返回一个月的start、end
     *
     * @param formatDate
     */
    private Date transStartDate(String formatDate) throws Exception {
        if (!StringUtils.isEmpty(formatDate)) {
//            String startDate = coventDate(formatDate, DateUtil.dateFormatter0);
            Date date = coventToDate(formatDate, DateUtil.dateFormatter0);
            return date;
        }
        return null;
    }

    /**
     * 返回一个月的start、end
     *
     * @param formatDate
     */
    private String transEndDate(String formatDate) throws Exception {
        if (!StringUtils.isEmpty(formatDate)) {
            String endDate = transDate(formatDate, DateUtil.dateFormatter0);
            return endDate;
        }
        return null;
    }

    /***
     *  获取30天以前的数据
     * @param dateStr
     * @param formater
     * @return
     * @throws Exception
     */
    public String coventDate(String dateStr, String formater) throws Exception {
        Calendar calc = Calendar.getInstance();
        calc.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr));
        calc.add(calc.DATE, -30);
        Date date = calc.getTime();
        String minDateStr = new SimpleDateFormat(formater).format(date);
//        String data2 =      new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println("minDateStr:" + minDateStr);
        return minDateStr;
    }

    /**
     * @param dateStr
     * @param formater
     * @return
     * @throws Exception
     */
    public Date coventToDate(String dateStr, String formater) throws Exception {
        Calendar calc = Calendar.getInstance();
        calc.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr));
        calc.add(calc.DATE, -30);
        Date date = calc.getTime();
//        String minDateStr = new SimpleDateFormat(formater).format(date);
//        String data2 =      new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println("Date:" + date);
        return date;
    }

    /***
     *
     * @param dateStr
     * @param formater
     * @return
     * @throws Exception
     */
    public String transDate(String dateStr, String formater) throws Exception {
        Calendar calc = Calendar.getInstance();
        calc.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr));
        Date minDate = calc.getTime();
        String minDateStr = new SimpleDateFormat(formater).format(minDate);
        System.out.println("minDateStr:" + minDateStr);
        return minDateStr;
    }
}
