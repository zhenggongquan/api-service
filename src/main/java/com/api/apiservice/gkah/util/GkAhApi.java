package com.api.apiservice.gkah.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.apiservice.param.AgentCode;
import com.api.apiservice.shandong.DecryptResult;
import com.api.apiservice.shandong.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author John
 **/
public class GkAhApi {
    private static final Logger logger = LoggerFactory.getLogger(GkAhApi.class);

    /***
     * 采购接口
     * @param url
     * @param privateKey
     * @param accessToken
     * @param account
     * @param password
     * @param startDate
     * @param endDate
     * @param currentPage
     * @param pageSize
     * @return
     */
    public static List<List> getPurData(String url, String privateKey, String accessToken,
                                             String account, String password, String startDate, String endDate,
                                                    Integer currentPage, Integer pageSize) {
        Map<String, Object> params = new HashMap<>(5);
        params.put("token", accessToken);
        params.put("userid", account);
        params.put("password", password);
        params.put("begindate", startDate);
        params.put("enddate", endDate);
        params.put("isfilter", 0);
        Map<String, String> requestParams = new HashMap<>(1);
        requestParams.put("input", JSON.toJSONString(params));
        String result = HttpClientUtil.doGet(url, requestParams);
        logger.info("采购接口返回值: {}", result);
        if (!StringUtils.isEmpty(result)) {
            String decrypt = DecryptResult.decrypt(result, privateKey);
            HashMap jsonMap = JSON.parseObject(decrypt, HashMap.class);
            // todo code 异常
            String code = String.valueOf(jsonMap.get("Code"));
            if(Integer.valueOf(code) > 0){
                logger.error("采购数据出错,错误原因是{}",jsonMap.get("Content"));
                return null;
            }
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
                //todo 取值
                item.add((String.valueOf(AgentCode.map.get(mp.get("ownername")))));
                item.add((String.valueOf(AgentCode.mapIndex.get(mp.get("ownername")))));
                records.addAll(Collections.singleton(item));
            }
            logger.info("国控山东采购返回值解密：{}", records);
            return records;
        }
        return null;
    }


    /***
     *
     * 销售
     * @param url
     * @param privateKey
     * @param accessToken
     * @param account
     * @param password
     * @param startDate
     * @param endDate
     * @param currentPage
     * @param pageSize
     * @return
     */
    public static List<List> getSaleData(String url, String privateKey, String accessToken,
                                     String account, String password, String startDate, String endDate,
                                     Integer currentPage, Integer pageSize) {
        Map<String, Object> params = new HashMap<>(5);
        params.put("accesstoken", accessToken);
        params.put("account", account);
        params.put("password", password);
        params.put("date1", startDate);
        params.put("date2", endDate);
        params.put("curpage", currentPage);
        params.put("pagesize", pageSize);
        params.put("isfilter", 0);
        Map<String, String> requestParams = new HashMap<>(1);
        requestParams.put("input", JSON.toJSONString(params));
        String result = HttpClientUtil.doGet(url, requestParams);
        logger.info("销售接口返回值: {}", result);
        if (!StringUtils.isEmpty(result)) {
            String decrypt = DecryptResult.decrypt(result, privateKey);
            HashMap jsonMap = JSON.parseObject(decrypt, HashMap.class);
            // todo code 异常
            String code = String.valueOf(jsonMap.get("Code"));
            if(Integer.valueOf(code) > 0){
                logger.error("销售出错,错误原因是{}",jsonMap.get("Content"));
                return null;
            }
            List<HashMap> tables = (List<HashMap>)jsonMap.get("Table");
            List<HashMap<String, Object>>  itemList = handleJSONArray(JSON.parseArray(JSON.toJSONString(tables)));
            List<List> records = new ArrayList<>();
            for(HashMap mp : itemList ){
                List<String> item = new ArrayList<>();
                item.add(String.valueOf(mp.get("rownum")));
                item.add(String.valueOf(mp.get("billno")));
                item.add(String.valueOf(mp.get("createdate")));
                item.add(String.valueOf(mp.get("billdate")));
                item.add(String.valueOf(mp.get("billtype")));
                item.add(String.valueOf(mp.get("custcode")));
                item.add(String.valueOf(mp.get("custname")));
                item.add(String.valueOf(mp.get("sendaddrid")));
                item.add(String.valueOf(mp.get("sendaddr")));
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
                item.add(String.valueOf(mp.get("purcode")));
                item.add(String.valueOf(mp.get("purname")));
                item.add(String.valueOf(mp.get("storename")));
                item.add(String.valueOf(mp.get("ownername")));
                item.add(String.valueOf(mp.get("batchid")));
                //todo 取值
                item.add((String.valueOf(AgentCode.map.get(mp.get("ownername")))));
                item.add((String.valueOf(AgentCode.mapIndex.get(mp.get("ownername")))));
                records.addAll(Collections.singleton(item));
            }
            logger.info("国控山东销售返回值解密：{}", records);
            return records;

        }
        return null;
    }



    /***
     *
     * @param url
     * @param privateKey
     * @param accessToken
     * @param account
     * @param password
     * @param startDate
     * @param endDate
     * @param currentPage
     * @param pageSize
     * @return
     */
    public static List<List> getStockInData(String url, String privateKey, String accessToken,
                                         String account, String password, String startDate, String endDate,
                                         Integer currentPage, Integer pageSize) {
        Map<String, Object> params = new HashMap<>(5);
        params.put("accesstoken", accessToken);
        params.put("account", account);
        params.put("password", password);
        params.put("date1", startDate);
        params.put("date2", endDate);
        params.put("curpage", currentPage);
        params.put("pagesize", pageSize);
        params.put("isfilter", 0);
        Map<String, String> requestParams = new HashMap<>(1);
        requestParams.put("input", JSON.toJSONString(params));
        String result = HttpClientUtil.doGet(url, requestParams);
        logger.info("库存数据接口返回值: {}", result);
        if (!StringUtils.isEmpty(result)) {
            String decrypt = DecryptResult.decrypt(result, privateKey);
            HashMap jsonMap = JSON.parseObject(decrypt, HashMap.class);
            // todo code 异常
            String code = String.valueOf(jsonMap.get("Code"));
            if(Integer.valueOf(code) > 0){
                logger.error("查询库存出错,错误原因是{}",jsonMap.get("Content"));
                return null;
            }
            List<HashMap> tables = (List<HashMap>)jsonMap.get("Table");
            List<HashMap<String, Object>>  itemList = handleJSONArray(JSON.parseArray(JSON.toJSONString(tables)));
            List<List> records = new ArrayList<>();
            for(HashMap mp : itemList ){
                List<String> item = new ArrayList<>();
                item.add(String.valueOf(mp.get("rownum")));
                item.add(String.valueOf(mp.get("stockdate")));
                item.add(String.valueOf(mp.get("indate")));
                item.add(String.valueOf(mp.get("prodcode")));
                item.add(String.valueOf(mp.get("prodname")));
                item.add(String.valueOf(mp.get("prodspec")));
                item.add(String.valueOf(mp.get("produnit")));
                item.add(String.valueOf(mp.get("prodproducer")));
                item.add(String.valueOf(mp.get("prodlotno")));
                item.add(String.valueOf(mp.get("prodprddate")));
                item.add(String.valueOf(mp.get("prodenddate")));
                item.add(String.valueOf(mp.get("prodquan")));
                item.add(String.valueOf(mp.get("purcode")));
                item.add(String.valueOf(mp.get("purname")));
                item.add(String.valueOf(mp.get("storename")));
                item.add(String.valueOf(mp.get("ownername")));
                item.add(String.valueOf(mp.get("batchid")));
                //todo 取值
                item.add((String.valueOf(AgentCode.map.get(mp.get("ownername")))));
                item.add((String.valueOf(AgentCode.mapIndex.get(mp.get("ownername")))));
                records.addAll(Collections.singleton(item));
            }
            return records;

        }
        return null;
    }

    /**
     *
     * @param jsonString
     * @return
     */
    public static HashMap<String, Object> fromJson2Map(String jsonString) {
        HashMap jsonMap = JSON.parseObject(jsonString, HashMap.class);
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        for(Iterator iter = jsonMap.keySet().iterator(); iter.hasNext();){
            String key = (String)iter.next();
            if(jsonMap.get(key) instanceof JSONArray){
                JSONArray jsonArray = (JSONArray)jsonMap.get(key);
                List list = handleJSONArray(jsonArray);
                resultMap.put(key, list);
            }else{
                resultMap.put(key, jsonMap.get(key));
            }
        }
        return resultMap;
    }

    /***
     *
     * @param jsonArray
     * @return
     */
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
