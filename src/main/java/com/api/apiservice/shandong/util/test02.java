package com.api.apiservice.shandong.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.apiservice.util.CsvUtil;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test02 {

    public static void main(String[] args) throws IOException {
        String doc ="{\n" +
                "    \"Code\":\"0\",\n" +
                "    \"Content\":\"数据已返回！\",\n" +
                "    \"Table\":[\n" +
                "        {\n" +
                "            \"rownum\":\"1\",\n" +
                "            \"billno\":\"CGDD1111907003672\",\n" +
                "            \"billdate\":\"2019-07-29 12:25:18\",\n" +
                "            \"billtype\":\"采购订单\",\n" +
                "            \"supcode\":\"****\",\n" +
                "            \"supname\":\"****\",\n" +
                "            \"prodcode\":\"****\",\n" +
                "            \"prodname\":\"测试数据\",\n" +
                "            \"prodspec\":\"****\",\n" +
                "            \"produnit\":\"****\",\n" +
                "            \"prodproducer\":\"****\",\n" +
                "            \"prodlotno\":\"****\",\n" +
                "            \"prodenddate\":\"2017-01-01 10:09:24\",\n" +
                "            \"prodquan\":\"1\",\n" +
                "            \"prodprice\":\"0.01\",\n" +
                "            \"prodamount\":\"0.01\",\n" +
                "            \"storename\":\"烟台仓储部\",\n" +
                "            \"ownername\":\"国药控股烟台有限公司\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"rownum\":\"3\",\n" +
                "            \"billno\":\"CGDD1211907001159\",\n" +
                "            \"billdate\":\"2019-07-29 14:56:28\",\n" +
                "            \"billtype\":\"采购订单\",\n" +
                "            \"supcode\":\"****\",\n" +
                "            \"supname\":\"****\",\n" +
                "            \"prodcode\":\"****\",\n" +
                "            \"prodname\":\"测试数据\",\n" +
                "            \"prodspec\":\"****\",\n" +
                "            \"produnit\":\"****\",\n" +
                "            \"prodproducer\":\"****\",\n" +
                "            \"prodlotno\":\"****\",\n" +
                "            \"prodenddate\":\"2017-01-01 10:09:24\",\n" +
                "            \"prodquan\":\"1\",\n" +
                "            \"prodprice\":\"0.01\",\n" +
                "            \"prodamount\":\"0.01\",\n" +
                "            \"storename\":\"济南WMS仓储部\",\n" +
                "            \"ownername\":\"国药控股济南有限公司\"\n" +
                "        }\n" +
                "\t\t]\n" +
                "\t\t}";


        HashMap jsonMap = JSON.parseObject(doc, HashMap.class);
        String code = (String) jsonMap.get("Code");
        List<HashMap> tables = (List<HashMap>)jsonMap.get("Table");
        List<HashMap<String, Object>>  itemList = handleJSONArray(JSON.parseArray(JSON.toJSONString(tables)));
        List<List> records = new ArrayList<>();
        for(HashMap mp : itemList ){
            List<String> item = new ArrayList<>();
            item.add(String.valueOf(mp.get("rownum")));
            item.add(String.valueOf(mp.get("billno")));
            item.add(String.valueOf(mp.get("billdate")));
            item.add(String.valueOf(mp.get("billtype")));
            item.add(String.valueOf(mp.get("supcode")));
            item.add(String.valueOf(mp.get("supname")));
            item.add(String.valueOf(mp.get("prodcode")));
            item.add(String.valueOf(mp.get("prodname")));
            item.add(String.valueOf(mp.get("prodspec")));
            item.add(String.valueOf(mp.get("produnit")));
            item.add(String.valueOf(mp.get("prodproducer")));
            item.add(String.valueOf(mp.get("prodlotno")));
            item.add(String.valueOf(mp.get("prodenddate")));
            item.add(String.valueOf(mp.get("prodquan")));
            item.add(String.valueOf(mp.get("prodprice")));
            item.add(String.valueOf(mp.get("prodamount")));
            item.add(String.valueOf(mp.get("storename")));
            item.add(String.valueOf(mp.get("ownername")));
            item.add("国药控股山东有限公司");
            item.add("1");
            records.addAll(Collections.singleton(item));
        }
        String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filedir ="shandong";
        String [] arrays = {"序号","采购单号","采购日期","订单类型","供应商编码","供应商名称","产品编码","产品名称 ",
                "产品规格","产品单位","生产厂家","产品批号","有效期","购进数量","购进单价","购进金额",
                "仓库名称","货主名称","经销商平台","经销商编号"};
        List<String> Headers= new ArrayList<>(Arrays.asList(arrays));
        CsvUtil.makeTempCSV(filedir,fileName, Headers, records);
        System.out.println("国控山东采购返回值解密：{}"+records);

    }
    private static List<HashMap<String, Object>> handleJSONArray(JSONArray jsonArray){
        List list = new ArrayList();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            HashMap map = new HashMap<String, Object>();
            for (Map.Entry entry : jsonObject.entrySet()) {
                if(entry.getValue() instanceof  JSONArray){
                    map.put((String)entry.getKey(), handleJSONArray((JSONArray)entry.getValue()));
                }else{
                    map.put((String)entry.getKey(), entry.getValue());
                }
            }
            list.add(map);
        }
        return list;
    }
}
