package com.api.apiservice.controller;

import com.alibaba.fastjson.JSON;
import com.api.apiservice.param.AxzeParam;
import com.api.apiservice.util.CsvUtil;
import com.api.apiservice.util.HttpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import static com.api.apiservice.axze.XMLUtilDoc.fromJson2Map;

/***
 * 爱心卓尔
 */
@RestController
@RequestMapping("/axze")
public class AxzeController {

    /***
     * 采购入库数据查询（axze.purchase.stock.in）
     * @param request
     * @param response
     */
    @RequestMapping("/stockin")
    @ResponseBody
    public String AxzeStockIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AxzeParam axzeParam = new AxzeParam("2019-07-10","",200,1,
                "DWI00000839","axze.purchase.stock.in","9121010660460338X6");
        Map map = HttpUtil.AxzeXMLHttpPost(axzeParam);
        int recordcount = Integer.parseInt(map.get("recordcount").toString());
        axzeParam.setCount(recordcount);
        int count  = axzeParam.totalPage();
        for(int i= 1 ;i < count+1; i++){
              axzeParam = new AxzeParam("2019-07-10","",200, i,
                    "DWI00000839","axze.purchase.stock.in","9121010660460338X6");
              map = HttpUtil.AxzeXMLHttpPost(axzeParam);
            String fileName = "采购单";
            String filedir ="shandong";
              String [] arrays = {"日期","商品编号","通用名称","单据类型","包装单位","商品规格","商品单位","生产厂家", "入库数量",
                      "含税单价","含税金额","税率","批号","生产日期","有效期","批准文号","委托人","采购负责人"};
            List<String> Headers= new ArrayList<>(Arrays.asList(arrays));
            List<List> details = new ArrayList<>();
            HashMap jsonMap = fromJson2Map(JSON.toJSONString(map));
            List<HashMap> itemList = (List<HashMap>)jsonMap.get("detail");
            for(HashMap mp : itemList ){
                List<String> item = new ArrayList<>();
                item.add(String.valueOf(mp.get("orderdate")));
                item.add(String.valueOf(mp.get("goodcode")));
                item.add(String.valueOf(mp.get("goodname")));
                item.add(String.valueOf(mp.get("ordertype")));
                item.add(String.valueOf(mp.get("packageunit")));
                item.add(String.valueOf(mp.get("spec")));
                item.add(String.valueOf(mp.get("unit")));
                item.add(String.valueOf(mp.get("manufactor")));
                item.add(String.valueOf(mp.get("quantity")));
                item.add(String.valueOf(mp.get("taxprice")));
                item.add(String.valueOf(mp.get("taxamount")));
                item.add(String.valueOf(mp.get("taxrate")));
                item.add(String.valueOf(mp.get("lotnumber")));
                item.add(String.valueOf(mp.get("manufacturedate")));
                item.add(String.valueOf(mp.get("validitydate")));
                item.add(String.valueOf(mp.get("approvalnumber")));
                item.add(String.valueOf(mp.get("client")));
                item.add(String.valueOf(mp.get("buyingpeople")));
                item.addAll(mp.values());
                details.addAll(Collections.singleton(item));
            }
            CsvUtil.makeTempCSV(filedir,fileName, Headers, details);

            return JSON.toJSONString(details);
        }
        return null;
    }

    /***
     *  销售出库数据查询（axze.sell.stock.out）
     * @param request
     * @param response
     */
    @RequestMapping("/stockout")
    public String AxzeStockOut(HttpServletRequest request, HttpServletResponse response){
        AxzeParam axzeParam = new AxzeParam("2019-07-10","",200,1,
                "DWI00000839","axze.sell.stock.out","9121010660460338X6");
        Map map = HttpUtil.AxzeXMLHttpPost(axzeParam);
        int recordcount = Integer.parseInt(map.get("recordcount").toString());
//        CsvUtil......
        axzeParam.setCount(recordcount);
        int count  = axzeParam.totalPage();
        for(int i= 2 ;i< count;i++){
            axzeParam = new AxzeParam("2019-07-10","",200, i,
                    "DWI00000839","axze.sell.stock.out","9121010660460338X6");
            map = HttpUtil.AxzeXMLHttpPost(axzeParam);
            //        CsvUtil......
        }
        return JSON.toJSONString(map);
    }

    /***
     *  批次库存查询(axze.stockroom.inventory)
     * @param request
     * @param response
     */
    @RequestMapping("/inventory")
    public String AxzeInventory (HttpServletRequest request, HttpServletResponse response){
        AxzeParam axzeParam = new AxzeParam("2019-07-10","",200,1,
                "DWI00000839","axze.stockroom.inventory","9121010660460338X6");
        Map map = HttpUtil.AxzeXMLHttpPost(axzeParam);
        int recordcount = Integer.parseInt(map.get("recordcount").toString());
//        CsvUtil......
        axzeParam.setCount(recordcount);
        int count  = axzeParam.totalPage();
        for(int i= 2 ;i< count;i++){
            axzeParam = new AxzeParam("2019-07-10","",200, i,
                    "DWI00000839","axze.stockroom.inventory","9121010660460338X6");
            map = HttpUtil.AxzeXMLHttpPost(axzeParam);
            //        CsvUtil......
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test (HttpServletRequest request, HttpServletResponse response){
        System.out.println("test。。。。。。。。。");
        return  "OK!";
    }
}
