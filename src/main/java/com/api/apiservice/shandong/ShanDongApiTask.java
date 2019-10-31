package com.api.apiservice.shandong;

import com.api.apiservice.util.Constants;
import com.api.apiservice.util.CsvUtil;
import com.api.apiservice.util.DateUtil;
import com.api.apiservice.util.FtpDataPushProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * @author John
 **/
@Component
public class ShanDongApiTask {
    @Value("${shandong.host}")
    private String host;
    @Value("${shandong.get-time-method-name}")
    private String getTimeMethodName;

    @Value("${shandong.purchase-method-name}")
    private String purchaseMethodName;

    @Value("${shandong.sale-method-name}")
    private String saleMethodName;

    @Value("${shandong.stockIn-method-name}")
    private String stockInMethodName;

    @Value("${shandong.access-token}")
    private String accessToken;
    @Value("${shandong.account}")
    private String account;
    @Value("${shandong.password}")
    private String password;
    @Value("${shandong.private-key}")
    private String privateKey;

    @Value("${shandong.upload.ip}")
    private String uploadIp;
    @Value("${shandong.upload.port}")
    private int uploadPort;
    @Value("${shandong.upload.username}")
    private String uploadUsername;
    @Value("${shandong.upload.password}")
    private String uploadPassword;

    //    @Autowired
//    private FtpDataPushProvider ftpDataPushProvider;
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final Logger logger = LoggerFactory.getLogger(ShanDongApiTask.class);

    /**
     * 采购 入库 上传
     *
     * @param endDate
     * @return
     */
//    @Scheduled(cron = "0 30 01 * * ? ")
    public String upLoadFile(String endDate) {
        List<String> filePaths = new ArrayList<>(2);
        try {
//            String apiEndDate = endDate;
//            if (StringUtils.isEmpty(apiEndDate)) {
//                Map<String, String> params = new HashMap<>(3);
//                params.put("accesstoken", accessToken);
//                params.put("account", account);
//                params.put("password", password);
//                String now = LocalDateTime.now().toString();
//                LocalDateTime localDateTime = LocalDateTime.parse(now, timeFormatter);
//                apiEndDate = localDateTime.format(dateFormatter);
//            }
            if (StringUtils.isEmpty(endDate)) {
                endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());  //当前时间
            }
            String filepath1 = generationData(endDate);
            Thread.sleep(19000);
            String filepath3 = generationStockInData(endDate);
            filePaths.add(filepath1);
            filePaths.add(filepath3);
        } catch (Exception ex) {
            logger.error("生成文件报错！{},{}", ex, ex.getMessage());
            return "生成文件报错!";
        }
        try {
            FtpDataPushProvider.doUpLoadFile(Constants.COMPANY_SHANDONGGUOYAO, filePaths,
                    uploadIp, uploadPort, uploadUsername, uploadPassword);
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
    public String uploadSale(String endDate) {
        List<String> filePaths = new ArrayList<>(3);
        try {
//            String apiEndDate = endDate;
//            if (StringUtils.isEmpty(apiEndDate)) {
//                Map<String, String> params = new HashMap<>(3);
//                params.put("accesstoken", accessToken);
//                params.put("account", account);
//                params.put("password", password);
//                String now = DateApi.getDate(host + getTimeMethodName, privateKey, params);
//                LocalDateTime localDateTime = LocalDateTime.parse(now, timeFormatter);
//                apiEndDate = localDateTime.format(dateFormatter);
//            }
            if (StringUtils.isEmpty(endDate)) {
                endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());  //当前时间
            }
//            String filepath2 = generationDataSaleData(StringUtils.isEmpty(endDate) ? apiEndDate : endDate);
            String filepath2 = generationDataSaleData(endDate);
            filePaths.add(filepath2);
        } catch (Exception ex) {
            logger.error("生成文件报错！{},{}", ex, ex.getMessage());
            return "生成文件报错!";
        }
        try {
            FtpDataPushProvider.doUpLoadFile(Constants.COMPANY_SHANDONGGUOYAO, filePaths,
                    uploadIp, uploadPort, uploadUsername, uploadPassword);
        } catch (Exception e) {
            logger.error("上传文件报错！{},{}", e, e.getMessage());
            return "上传文件报错!";
        }
        return "OK!";
    }

    /**
     * 采购
     *
     * @return
     * @throws Exception
     * @Scheduled
     */
    public String generationData(String formatDate) throws Exception {
        Map<String, String> params = new HashMap<>(3);
        params.put("accesstoken", accessToken);
        params.put("account", account);
        params.put("password", password);
        String startDate = "";
        String endDate = "";
//        LocalDateTime localDateTime;
//        if (StringUtils.isEmpty(formatDate)) {
//            String now = DateApi.getDate(host + getTimeMethodName, privateKey, params);
//            localDateTime = LocalDateTime.parse(now, timeFormatter);
//            endDate = localDateTime.format(dateFormatter);
//            startDate = localDateTime.minusDays(90).format(dateFormatter);
//        } else {
        endDate = formatDate;
//        startDate = DateUtil.coventDate(formatDate, DateUtil.dateFormatter1);
        startDate =  DateUtil.conventFormatDate(formatDate,DateUtil.dateFormatter1,90, DateUtil.dateFormatter1);
        logger.info("计算到的开始日期为：{}, 结束日期为: {}", startDate, endDate);
        List<List> records = new ArrayList();
        String fileName = "采购单";
        String filedir = "shandong";
        String[] arrays = {"序号", "采购单号", "采购日期", "订单类型", "供应商编码", "供应商名称", "产品编码", "产品名称",
                "产品规格", "产品单位", "生产厂家", "产品批号", "有效期", "购进数量", "购进单价", "购进金额",
                "仓库名称", "货主名称", "经销商平台", "经销商编号"};
        List<String> Headers = new ArrayList<>(Arrays.asList(arrays));
        int currentPage = 1;
        File file = null;
        try {
            do {
                records = PurchaseApi.getData(host + purchaseMethodName, privateKey,
                        accessToken, account, password, startDate, endDate, currentPage, 200);
                if (currentPage == 1) {
                    file = CsvUtil.makeTempCSV(filedir, fileName, Headers, records);
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


    /***
     *
     * 销售数据
     *  @Scheduled(cron = "0/10 * * * * ? ")
     * @return
     * @throws Exception
     */
    public String generationDataSaleData(String formatDate) throws Exception {
        Map<String, String> params = new HashMap<>(3);
        params.put("accesstoken", accessToken);
        params.put("account", account);
        params.put("password", password);
        String startDate = "";
        String endDate = "";
//        LocalDateTime localDateTime;
//        if (StringUtils.isEmpty(formatDate)) {
//            String now = DateApi.getDate(host + getTimeMethodName, privateKey, params);
//            localDateTime = LocalDateTime.parse(now, timeFormatter);
//            endDate = localDateTime.format(dateFormatter);
//            startDate = localDateTime.minusDays(90).format(dateFormatter);
//        } else {
//            localDateTime = LocalDateTime.parse(formatDate, dateFormatter);
        endDate = formatDate;
        startDate = DateUtil.coventDate(formatDate, DateUtil.dateFormatter1);
//        startDate =  DateUtil.conventFormatDate(formatDate,DateUtil.dateFormatter1,90, DateUtil.dateFormatter1);
//        }
        logger.info("计算到的开始日期为：{}, 结束日期为: {}", startDate, endDate);
        List<List> records = new ArrayList();
        String fileName = "销售单";
        String fileDir = "shandong";
        String[] arrays = {"序号", "销售单号", "开单日期", "出库复核日期", "订单类型", "客户编码", "客户名称", "客户地址编号",
                "客户地址", "产品编码", "产品名称", "产品规格", "产品单位", "生产厂家", "产品批号", "有效期至",
                "销售数量", "销售单价", "销售金额", "原供货商编码", "原供货商名称", "仓库名称", "货主名称", "批次号", "经销商平台", "经销商编号"};
        List<String> Headers = new ArrayList<>(Arrays.asList(arrays));
        int currentPage = 1;
        File file = null;
        try {
            do {
                records = PurchaseApi.getSaleData(host + saleMethodName, privateKey,
                        accessToken, account, password, startDate, endDate, currentPage, 200);
                if (currentPage == 1 && records != null && !records.isEmpty()) {
                    file = CsvUtil.makeTempCSV(fileDir, fileName, Headers, records);
                } else {
                    CsvUtil.appendFileCsv(file.getAbsoluteFile(), records);
                }
                currentPage++;

            } while (records != null && records.size() == 200);
            return file.getAbsolutePath();
        } catch (IOException e) {
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
        Map<String, String> params = new HashMap<>(3);
        params.put("accesstoken", accessToken);
        params.put("account", account);
        params.put("password", password);
        String startDate = "";
        String endDate = "";
//        LocalDateTime localDateTime;
//        if (StringUtils.isEmpty(formatDate)) {
//            String now = DateApi.getDate(host + getTimeMethodName, privateKey, params);
//            localDateTime = LocalDateTime.parse(now, timeFormatter);
//            endDate = localDateTime.format(dateFormatter);
//            startDate = localDateTime.minusDays(90).format(dateFormatter);
//        } else {
        endDate = formatDate;
        startDate = DateUtil.coventDate(formatDate, DateUtil.dateFormatter1);
//        }
        logger.info("计算到的开始日期为：{}, 结束日期为: {}", startDate, endDate);
        List<List> records = new ArrayList();
        String fileName = "库存单";
        String fileDir = "shandong";
        String[] arrays = {"序号", "库存日期", "最近一次入库日期", "产品编码", "产品名称", "产品规格", "产品单位", "生产厂家",
                "产品批号", "生产日期", "有效期至", "库存数量", "原供货商编码", "原供货商名称", "仓库名称", "货主名称", "批次号", "经销商平台", "经销商编号"};
        List<String> Headers = new ArrayList<>(Arrays.asList(arrays));
        int currentPage = 1;
        File file = null;
        try {
            do {
                records = PurchaseApi.getStockInData(host + stockInMethodName, privateKey,
                        accessToken, account, password, startDate, endDate, currentPage, 200);
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
