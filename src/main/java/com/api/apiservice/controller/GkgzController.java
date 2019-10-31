package com.api.apiservice.controller;

import com.api.apiservice.gkgzWebService.GkgzApiTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 国控广州
 *
 * @author net
 * @since 2019-10-28 16:11:13
 */
@RestController
@RequestMapping("/gkgz")
public class GkgzController {

    @Autowired
    private GkgzApiTask gkgzApiTask;
    /***
     *
     * @param request
     * @param response
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String getData(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam String endDate) {
        return gkgzApiTask.upLoadFile(endDate);
    }

//
//    /**
//     * 采购接口查询
//     *
//     * @param request
//     * @param response
//     * @param date
//     * @author net
//     * @since 2019-10-27 13:17:35
//     */
//    @RequestMapping("/qkgzPurchase")
//    @ResponseBody
//    public String gzPurchase(HttpServletRequest request, HttpServletResponse response, String date) throws javax.xml.rpc.ServiceException, IOException {
//
//        //采集90天内 接口最多请求30天的，故分3次 每次30天查询
//        VendorDDIServiceLocator locator = new VendorDDIServiceLocator();
//        VendorService vendorService = locator.getvendorDDIPort();
//        PurchaseInfo[] szyz_st01s = vendorService.getPurchaseInfo("1", DateUtil.getBeforeDate(date, 91),
//                DateUtil.getBeforeDate(date, 61), "SSGJ", "ssgj1234");
//        PurchaseInfo[] szyz_st02s = vendorService.getPurchaseInfo("1", DateUtil.getBeforeDate(date, 61),
//                DateUtil.getBeforeDate(date, 31), "SSGJ", "ssgj1234");
//        PurchaseInfo[] szyz_st03s = vendorService.getPurchaseInfo("1", DateUtil.getBeforeDate(date, 31),
//                DateUtil.getBeforeDate(date, 1), "SSGJ", "ssgj1234");
//        PurchaseInfo[] all = concatAll(szyz_st01s, szyz_st02s, szyz_st03s);
//
//        JSONArray array= JSONArray.fromObject(all);
//        List mapValue = getMapValue(array.toString());
////        List<List> items = new ArrayList<>();
////        for (PurchaseInfo szyz_st01 : all) {
////            List list = new ArrayList<>();
////            String s = JSONObject.toJSONString(szyz_st01);
////            list = getMapValue(s);
////            items.add(list);
////        }
//        String[] headers = {"订单号", "采购日期", "采购部门", "数量", "单据类型", "单据ID，PK", "无税单价", "无税金额", "货主ID", "货主名称",
//                "包装数量", "含税单价", "生产日期", "生产厂家", "批号", "进口国产合资", "商品编码", "商品名称", "规格", "单位", "质量状态",
//                "库存状态", "有限期", "含税金额", "供应商编码", "供应商名称"};
//        HunNanCsvUtils.createFile(mapValue, headers, "D:\\gzgk.csv");
//        return "success";
//    }
//
//    /**
//     * 销售信息查询
//     *
//     * @param request
//     * @param response
//     * @param date
//     * @author net
//     * @since 2019-10-28 13:28:54
//     */
//    @RequestMapping("/qkgzSaleInfo")
//    @ResponseBody
//    public String gzSaleInfo(HttpServletRequest request, HttpServletResponse response, String date) throws javax.xml.rpc.ServiceException, IOException {
//
//        //采集90天内 接口最多请求30天的，故分3次 每次30天查询
//        VendorDDIServiceLocator locator = new VendorDDIServiceLocator();
//        VendorService vendorService = locator.getvendorDDIPort();
//        SaleInfo[] szyz_st01s = vendorService.getSaleInfo("1", DateUtil.getBeforeDate(date, 91),
//                DateUtil.getBeforeDate(date, 61), "SSGJ", "ssgj1234");
//        SaleInfo[] szyz_st02s = vendorService.getSaleInfo("1", DateUtil.getBeforeDate(date, 61),
//                DateUtil.getBeforeDate(date, 31), "SSGJ", "ssgj1234");
//        SaleInfo[] szyz_st03s = vendorService.getSaleInfo("1", DateUtil.getBeforeDate(date, 31),
//                DateUtil.getBeforeDate(date, 1), "SSGJ", "ssgj1234");
//        SaleInfo[] all = concatAll(szyz_st01s, szyz_st02s, szyz_st03s);
//        List mapValue = getMapValue(JSON.toJSONString(all));
//
//        String[] headers = {"订单号", "采购日期", "采购部门", "数量", "单据类型", "单据ID，PK", "无税单价", "无税金额", "货主ID", "货主名称",
//                "包装数量", "含税单价", "生产日期", "生产厂家", "批号", "进口国产合资", "商品编码", "商品名称", "规格", "单位", "质量状态",
//                "库存状态", "有限期", "含税金额", "供应商编码", "供应商名称"};
//        HunNanCsvUtils.createFile(mapValue, headers, "D:\\gzgkSale.csv");
//        return "success";
//    }
//
//    @RequestMapping("/gzStockInfo")
//    @ResponseBody
//    public String gzStockInfo(HttpServletRequest request, HttpServletResponse response) throws javax.xml.rpc.ServiceException, IOException {
//
//        return "success";
//    }
//
//    private List<List> getListByJsonStr(String jsonListStr) {
//        List<List> list= Lists.newArrayList();
//        List<Map> mapList= JSON.parseArray(jsonListStr,Map.class);
//        for(Map mapField:mapList){
//            List listFields=Lists.newArrayList();
//            for(Object field:mapField.values()){
//                listFields.add(field);
//            }
//            list.add(listFields);
//        }
//        return  list;
//    }
//
//    public static List getMapValue(String jsonString) {
//        System.out.println(jsonString);
//        JSONObject parse = (JSONObject) JSON.parse(jsonString);
//        Map map = JSONObject.toJavaObject(parse, Map.class);
//        List list = new ArrayList<>();
//        List<String> fields = new ArrayList<>();
//        Collection<Object> str = map.values();
//        for (Object obj : str) {
//            if (obj != null) {
//                fields.add(obj.toString());
//            } else {
//                fields.add("");
//            }
//        }
//        list.add(fields);
//
//        return list;
//    }
//
//    public static List<List> getListValue(String jsonString) {
//        System.out.println(jsonString);
//        JSONObject parse = (JSONObject) JSON.parse(jsonString);
//        JSONObject xmlData = (JSONObject) parse.get("xmlData");
//        JSONArray items = (JSONArray) xmlData.get("items");
//        if (items == null) {
//            return null;
//        }
//        List<Map> itemsList = new ArrayList<>();
//        for (Object item : items) {
//            itemsList.addAll((List<Map>) item);
//        }
//        List<List> list = new ArrayList<>();
//        for (Map map : itemsList) {
//            List<String> fields = new ArrayList<>();
//            Collection<Object> str = map.values();
//            for (Object obj : str) {
//                if (obj != null) {
//                    fields.add(obj.toString());
//                } else {
//                    fields.add("");
//                }
//            }
//            list.add(fields);
//        }
//        return list;
//    }
//    /**
//     * 数组拼接
//     * @param first
//     * @param rest
//     * @author net
//     * @since 2019-10-28 19:50:52
//     */
//    public static <T> T[] concatAll(T[] first, T[]... rest) {
//        int totalLength = first.length;
//        for (T[] array : rest) {
//            totalLength += array.length;
//        }
//        T[] result = Arrays.copyOf(first, totalLength);
//        int offset = first.length;
//        for (T[] array : rest) {
//            System.arraycopy(array, 0, result, offset, array.length);
//            offset += array.length;
//        }
//        return result;
//    }
}
