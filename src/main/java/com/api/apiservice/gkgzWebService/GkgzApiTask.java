package com.api.apiservice.gkgzWebService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.apiservice.gkgzWebService.util.DateUtil;
import com.api.apiservice.util.Constants;
import com.api.apiservice.util.CsvUtil;
import com.api.apiservice.util.FtpDataPushProvider;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * @author John
 **/
@Component
public class GkgzApiTask {

    @Value("${guoyaoguangzhou.username}")
    private String username;
    @Value("${guoyaoguangzhou.password}")
    private String password;

    @Value("${guoyaoguangzhou.upload.ip}")
    private String uploadIp;
    @Value("${guoyaoguangzhou.upload.port}")
    private int uploadPort;
    @Value("${guoyaoguangzhou.upload.username}")
    private String uploadUsername;
    @Value("${guoyaoguangzhou.upload.password}")
    private String uploadPassword;


    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final Logger logger = LoggerFactory.getLogger(GkgzApiTask.class);

    private  Map<String, String> generateCode () {
        Map<String,String> codeMap = new HashMap<>();
        codeMap.put("1", "1-8Q-61");
        codeMap.put("6", "1-8Q-30");
        codeMap.put("14", "1-8Q-318");
        codeMap.put("5", "1-8Q-47");
        codeMap.put("13", "1-VXFPH");
        codeMap.put("12", "1-8Q-63");
        codeMap.put("19", "1-2PHQUV");
        codeMap.put("11", "1-8Q-65");
        codeMap.put("24", "1-MRXE5");
        codeMap.put("21", "1-11526V");
        codeMap.put("7", "1-8Q-73");
        codeMap.put("17", "1-27I5J");
        codeMap.put("20", "1-1H0FB");
        codeMap.put("2", "1-8Q-356");
        codeMap.put("8", "1-8Q-215");

        return codeMap;
    }

    /**
     * @param endDate
     * @return
     */
//    @Scheduled(cron = "0/10 * * * * ? ")
    public String upLoadFile(String endDate) {
        List<String> filePaths = new ArrayList<>(3);
        try {
            String filepath1 = generationData(endDate);
            String filepath2 = generationDataSaleData(endDate);
            String filepath3 = generationStockInData(endDate);
            filePaths.add(filepath1);
            filePaths.add(filepath2);
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
     * 采购
     *
     * @return
     * @throws Exception
     * @Scheduled (cron = " 0 / 10 * * * * ? ")
     */
    public String generationData(String date) throws Exception {
        File file = null;
        try {
            //采集90天内 接口最多请求30天的，故分3次 每次30天查询
            VendorDDIServiceLocator locator = new VendorDDIServiceLocator();
            VendorService vendorService = locator.getvendorDDIPort();
            Map<String,String> codeMap = generateCode();
            PurchaseInfo[] all = {};
            for (Iterator iter = codeMap.entrySet().iterator(); iter.hasNext();) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                PurchaseInfo[] szyz_st01s = vendorService.getPurchaseInfo(entry.getKey(), DateUtil.getBeforeDate(date, 91),
                        DateUtil.getBeforeDate(date, 61), "SSGJ", "ssgj1234");
                PurchaseInfo[] szyz_st02s = vendorService.getPurchaseInfo(entry.getKey(), DateUtil.getBeforeDate(date, 61),
                        DateUtil.getBeforeDate(date, 31), "SSGJ", "ssgj1234");
                PurchaseInfo[] szyz_st03s = vendorService.getPurchaseInfo(entry.getKey(), DateUtil.getBeforeDate(date, 31),
                        DateUtil.getBeforeDate(date, 1), "SSGJ", "ssgj1234");
                all = concatAll(all,szyz_st01s, szyz_st02s, szyz_st03s);
            }
            JSONArray array= JSONArray.fromObject(all);
            List mapValue = getArrListValue(array,this.generateCode());
            String[] headers = {"订单号", "采购日期", "采购部门", "数量", "单据类型", "单据ID，PK", "无税单价", "无税金额", "货主ID", "货主名称",
                    "包装数量", "含税单价", "生产日期", "生产厂家", "批号", "进口国产合资", "商品编码", "商品名称", "规格", "单位", "质量状态",
                    "库存状态", "有限期", "含税金额", "供应商编码", "供应商名称","经销商编号平台系统"};
            String fileName = "采购单";
            String filedir = "gygz";
            file = CsvUtil.makeTempCSV(filedir, fileName, new ArrayList(Arrays.asList(headers)), mapValue);
        } catch (Exception e) {
            throw e;
        }
        return file.getAbsolutePath();

    }


    /***
     *
     * 销售数据
     *  @Scheduled(cron = "0/10 * * * * ? ")
     * @return
     * @throws Exception
     */
    public String generationDataSaleData(String date) throws Exception {
        File file = null;
        try {
            //采集90天内 接口最多请求30天的，故分3次 每次30天查询
            VendorDDIServiceLocator locator = new VendorDDIServiceLocator();
            VendorService vendorService = locator.getvendorDDIPort();
            Map<String,String> codeMap = generateCode();
            SaleInfo[] all = {};
            for (Iterator iter = codeMap.entrySet().iterator(); iter.hasNext();) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                SaleInfo[] szyz_st01s = vendorService.getSaleInfo(entry.getKey(), DateUtil.getBeforeDate(date, 91),
                        DateUtil.getBeforeDate(date, 61), "SSGJ", "ssgj1234");
                SaleInfo[] szyz_st02s = vendorService.getSaleInfo(entry.getKey(), DateUtil.getBeforeDate(date, 61),
                        DateUtil.getBeforeDate(date, 31), "SSGJ", "ssgj1234");
                SaleInfo[] szyz_st03s = vendorService.getSaleInfo(entry.getKey(), DateUtil.getBeforeDate(date, 31),
                        DateUtil.getBeforeDate(date, 1), "SSGJ", "ssgj1234");
                all = concatAll(all, szyz_st01s, szyz_st02s, szyz_st03s);
            }
//            SaleInfo[] szyz_st01s = vendorService.getSaleInfo("1", DateUtil.getBeforeDate(date, 91),
//                    DateUtil.getBeforeDate(date, 61), "SSGJ", "ssgj1234");
//            SaleInfo[] szyz_st02s = vendorService.getSaleInfo("1", DateUtil.getBeforeDate(date, 61),
//                    DateUtil.getBeforeDate(date, 31), "SSGJ", "ssgj1234");
//            SaleInfo[] szyz_st03s = vendorService.getSaleInfo("1", DateUtil.getBeforeDate(date, 31),
//                    DateUtil.getBeforeDate(date, 1), "SSGJ", "ssgj1234");
//            SaleInfo[] all = concatAll(szyz_st01s, szyz_st02s, szyz_st03s);

            JSONArray array= JSONArray.fromObject(all);
            List mapValue = getArrListValue(array,this.generateCode());

            String[] headers = {"订单号", "客户区域", "客户编码", "客户名称", "客户类型", "销售部门", "数量", "单据类型", "单据ID，pk", "开票日期",
                    "发票号", "不含税单价", "不含税金额", "货主ID", "货主名称", "包装数量", "含税单价", "生产厂家", "批号", "进口国产合资", "商品编码",
                    "商品名称", "规格", "单位", "出库时间", "销售时间","送货地址","送货地址编码","运输方式","释放日期","含税金额","供应商编码","供应商名称","经销商编号平台系统"};
            String fileName = "销售单";
            String filedir = "gygz";

            file = CsvUtil.makeTempCSV(filedir, fileName, new ArrayList(Arrays.asList(headers)), mapValue);
        } catch (Exception ex) {
            throw ex;
        }
        return file.getAbsolutePath();
    }


    /***
     *   @Scheduled(cron = "0/10 * * * * ? ")
     * @return 库存数据
     * @throws Exception
     */
    public String generationStockInData(String date) throws Exception {
        File file = null;
        try {
            //采集90天内 接口最多请求30天的，故分3次 每次30天查询
            VendorDDIServiceLocator locator = new VendorDDIServiceLocator();
            VendorService vendorService = locator.getvendorDDIPort();
            Map<String,String> codeMap = generateCode();
            StockInfo[] all = {};
            for (Iterator iter = codeMap.entrySet().iterator(); iter.hasNext();) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                all = concatAll(all, vendorService.getStockInfo(entry.getKey(), "SSGJ", "ssgj1234"));
            }
            JSONArray array= JSONArray.fromObject(all);
            List mapValue = getArrListValue(array,this.generateCode());
            String[] headers = {"货主ID", "货主名称", "包装数量", "生成日期", "生产厂家", "批号", "进口国产合资", "商品编码", "商品名称",
                    "规格", "单位", "质量状态", "库存数量", "库存状态", "有效期","经销商编号平台系统"};
            String fileName = "库存单";
            String filedir = "gygz";

            file = CsvUtil.makeTempCSV(filedir, fileName, new ArrayList(Arrays.asList(headers)), mapValue);
        } catch (Exception ex) {
            throw ex;
        }
        return file.getAbsolutePath();
    }

    public static List getMapValue(String jsonString) {
        System.out.println(jsonString);
        JSONObject parse = (JSONObject) JSON.parse(jsonString);
        Map map = JSONObject.toJavaObject(parse, Map.class);
        List list = new ArrayList<>();
        List<String> fields = new ArrayList<>();
        Collection<Object> str = map.values();
        for (Object obj : str) {
            if (obj != null) {
                fields.add(obj.toString());
            } else {
                fields.add("");
            }
        }
        list.add(fields);

        return list;
    }

    public static List<List> getArrListValue(JSONArray items, Map<String, String> codeMap) {
        if (items == null) {
            return null;
        }
        List<Map> itemsList = items;
        List<List> list = new ArrayList<>();
        for (Map map : itemsList) {
            List<String> fields = new ArrayList<>();
            Collection<Object> str = map.values();
            for (Object obj : str) {
                if (obj != null) {
                    fields.add(obj.toString());
                } else {
                    fields.add("");
                }
            }
            fields.add(codeMap.get(map.get("ownerID")));
            list.add(fields);
        }
        return list;
    }
    /**
     * 数组拼接
     *
     * @param first
     * @param rest
     * @author net
     * @since 2019-10-28 19:50:52
     */
    public static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}
