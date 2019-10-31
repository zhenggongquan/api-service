package com.api.apiservice.axze;

import com.alibaba.fastjson.JSON;
import com.api.apiservice.param.AxzeParam;
import com.api.apiservice.shandong.DateApi;
import com.api.apiservice.shandong.PurchaseApi;
import com.api.apiservice.shandong.ShanDongApiTask;
import com.api.apiservice.util.Constants;
import com.api.apiservice.util.CsvUtil;
import com.api.apiservice.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static com.api.apiservice.axze.XMLUtilDoc.fromJson2Map;

//public class AxzeApiTask {
//    private static final Logger logger = LoggerFactory.getLogger(AxzeApiTask.class);

    /**
     * @param endDate
     * @return
     */
//    public String upLoadFile(String endDate) {
//        List<String> filePaths = new ArrayList<>(3);
//        try {
//            String filepath1 = generationData(endDate);
////            String filepath2 = generationDataSaleData(endDate);
////            String filepath3 = generationStockInData(endDate);
////            filePaths.add(filepath1);
////            filePaths.add(filepath2);
////            filePaths.add(filepath3);
//        } catch (Exception ex) {
//            logger.error("生成文件报错！{},{}", ex, ex.getMessage());
//            return "生成文件报错!";
//        }
//        try {
////            ftpDataPushProvider.doUpLoadFile(Constants.COMPANY_SHANDONGGUOYAO, filePaths);
//        } catch (Exception e) {
//            logger.error("上传文件报错！{},{}", e, e.getMessage());
//            return "上传文件报错!";
//        }
//        return "OK!";
//    }

    /**
     * @return
     * @throws Exception
     * @Scheduled (cron = " 0 / 10 * * * * ? ")
     */
//    public String generationData(String formatDate) throws Exception {
//
//        AxzeParam axzeParam = new AxzeParam("2019-07-10", "", 200, 1,
//                "DWI00000839", "axze.purchase.stock.in", "9121010660460338X6");
//        Map map = HttpUtil.AxzeXMLHttpPost(axzeParam);
//        int recordcount = Integer.parseInt(map.get("recordcount").toString());
//        axzeParam.setCount(recordcount);
//        int totalPage = axzeParam.totalPage();
//        String fileName = "采购单";
//        String filedir = "shandong";
//        File file = null;
//        String[] arrays = {"日期", "商品编号", "通用名称", "单据类型", "包装单位", "商品规格", "商品单位", "生产厂家", "入库数量",
//                "含税单价", "含税金额", "税率", "批号", "生产日期", "有效期", "批准文号", "委托人", "采购负责人"};
//        List<String> Headers = new ArrayList<>(Arrays.asList(arrays));
//        for (int current = 1; current < totalPage + 1; current++) {
//            axzeParam = new AxzeParam("2019-07-10", "", 200, current,
//                    "DWI00000839", "axze.purchase.stock.in", "9121010660460338X6");
//            map = HttpUtil.AxzeXMLHttpPost(axzeParam);
//            List<List> records = new ArrayList<>();
//            HashMap jsonMap = fromJson2Map(JSON.toJSONString(map));
//            List<HashMap> itemList = (List<HashMap>) jsonMap.get("detail");
//            for (HashMap mp : itemList) {
//                List<String> item = new ArrayList<>();
//                item.add(String.valueOf(mp.get("orderdate")));
//                item.add(String.valueOf(mp.get("goodcode")));
//                item.add(String.valueOf(mp.get("goodname")));
//                item.add(String.valueOf(mp.get("ordertype")));
//                item.add(String.valueOf(mp.get("packageunit")));
//                item.add(String.valueOf(mp.get("spec")));
//                item.add(String.valueOf(mp.get("unit")));
//                item.add(String.valueOf(mp.get("manufactor")));
//                item.add(String.valueOf(mp.get("quantity")));
//                item.add(String.valueOf(mp.get("taxprice")));
//                item.add(String.valueOf(mp.get("taxamount")));
//                item.add(String.valueOf(mp.get("taxrate")));
//                item.add(String.valueOf(mp.get("lotnumber")));
//                item.add(String.valueOf(mp.get("manufacturedate")));
//                item.add(String.valueOf(mp.get("validitydate")));
//                item.add(String.valueOf(mp.get("approvalnumber")));
//                item.add(String.valueOf(mp.get("client")));
//                item.add(String.valueOf(mp.get("buyingpeople")));
//                item.addAll(mp.values());
//                records.addAll(Collections.singleton(item));
//            }
//            CsvUtil.makeTempCSV(filedir, fileName, Headers, records);
//            if (current == 1) {
//                file = CsvUtil.makeTempCSV(filedir, fileName, Headers, records);
//            } else {
//                CsvUtil.appendFileCsv(file.getAbsoluteFile(), records);
//            }
//            return file.getAbsolutePath();
//
////        }
////    }
//}
        /***
         *
         * 销售数据
         *  @Scheduled(cron = "0/10 * * * * ? ")
         * @return
         * @throws Exception
         */
//    public String generationDataSaleData(String formatDate) throws Exception {
//        Map<String, String> params = new HashMap<>(3);
//        params.put("accesstoken", accessToken);
//        params.put("account", account);
//        params.put("password", password);
//        String startDate = "";
//        String endDate = "";
//        LocalDateTime localDateTime;
//        if (StringUtils.isEmpty(formatDate)) {
//            String now = DateApi.getDate(host + getTimeMethodName, privateKey, params);
//            localDateTime = LocalDateTime.parse(now, timeFormatter);
//        } else {
//            localDateTime = LocalDateTime.parse(formatDate, dateFormatter);
//        }
//        endDate = localDateTime.format(dateFormatter);
//        startDate = localDateTime.minusDays(90).format(dateFormatter);
//        logger.info("计算到的开始日期为：{}, 结束日期为: {}", startDate, endDate);
//        List<List>  records = new ArrayList();
//        String fileName = "销售单";
//        String fileDir ="shandong";
//        String [] arrays = {"序号","销售单号","开单日期","出库复核日期","订单类型","客户编码","客户名称","客户地址编号",
//                "客户地址","产品编码","产品名称","产品规格","产品单位","生产厂家","产品批号","有效期至",
//                "销售数量","销售单价","销售金额","原供货商编码","原供货商名称","仓库名称","货主名称","批次号","经销商平台","经销商编号"};
//        List<String> Headers= new ArrayList<>(Arrays.asList(arrays));
//        int currentPage = 1 ;
//        File file = null;
//        try {
//            do{
//                records = PurchaseApi.getSaleData(host + purchaseMethodName, privateKey,
//                        accessToken, account, password, startDate, endDate, currentPage, 200);
//
//                if(currentPage ==1 && records !=null && !records.isEmpty()){
//                    file =CsvUtil.makeTempCSV(fileDir,fileName, Headers, records);
//                }else {
//                    CsvUtil.appendFileCsv(file.getAbsoluteFile(),records);
//                }
//                currentPage ++;
//
//            } while (records !=null && records.size() == 200);
//            return file.getAbsolutePath();
//        } catch (IOException e) {
//            logger.error("销售数据出错！");
//            throw e;
//        }
//
//    }


        /***
         *   @Scheduled(cron = "0/10 * * * * ? ")
         * @return 库存数据
         * @throws Exception
         */
//    public String generationStockInData(String formatDate) throws Exception{
//        Map<String, String> params = new HashMap<>(3);
//        params.put("accesstoken", accessToken);
//        params.put("account", account);
//        params.put("password", password);
//        String startDate = "";
//        String endDate = "";
//        LocalDateTime localDateTime;
//        if (StringUtils.isEmpty(formatDate)) {
//            String now = DateApi.getDate(host + getTimeMethodName, privateKey, params);
//            localDateTime = LocalDateTime.parse(now, timeFormatter);
//        } else {
//            localDateTime = LocalDateTime.parse(formatDate, dateFormatter);
//        }
//        endDate = localDateTime.format(dateFormatter);
//        startDate = localDateTime.minusDays(90).format(dateFormatter);
//        logger.info("计算到的开始日期为：{}, 结束日期为: {}", startDate, endDate);
//        List<List>  records = new ArrayList();
//        String fileName = "库存单";
//        String fileDir ="shandong";
//        String [] arrays = {"序号","库存日期","最近一次入库日期","产品编码","产品名称","产品规格","产品单位","生产厂家",
//                "产品批号","生产日期","有效期至","库存数量","原供货商编码","原供货商名称","仓库名称","货主名称","批次号","经销商平台","经销商编号"};
//        List<String> Headers= new ArrayList<>(Arrays.asList(arrays));
//        int currentPage = 1 ;
//        File file = null;
//        try {
//            do {
//                records = PurchaseApi.getStockInData(host + purchaseMethodName, privateKey,
//                        accessToken, account, password, startDate, endDate, currentPage, 200);
//
//                if(currentPage ==1){
//                    file =CsvUtil.makeTempCSV(fileDir,fileName, Headers, records);
//                }else {
//                    CsvUtil.appendFileCsv(file.getAbsoluteFile(),records);
//                }
//                currentPage ++;
//
//            } while (records !=null && records.size() == 200);
//            return file.getAbsolutePath();
//        } catch (IOException e) {
//            logger.error("库存数据出错！");
//            throw e;
//        }
//    }