package com.api.apiservice.flow;

import com.alibaba.fastjson.JSON;
import com.api.apiservice.param.HnjxyyParam;
import com.api.apiservice.util.Constants;
import com.api.apiservice.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class HnjxyyFlowDirection   {
    private static final Logger logger = LoggerFactory.getLogger(HnjxyyFlowDirection.class);

    /**
     * 凭证获取接口

     * @return
     */
    public String getAccessToken(HnjxyyParam hnjxyyParam) {
        Map map = new HashMap();
        map.put("username",hnjxyyParam.getUsername());
        map.put("password",hnjxyyParam.getPassword());
        try {
          String jsonObject = HttpUtil.HttpClientGet(Constants.GET_ACCESS_TOKEN,map);
           Map  resultMap = JSON.parseObject(jsonObject,Map.class);
            String access_token =null ;
            if("success".equals(resultMap.get("errmsg"))){
                access_token = (String) resultMap.get("access_token");
            }
            return access_token ;
        } catch (Exception e) {
            logger.info(e.getMessage(),e);
        }
        return null;
    }

    /***
     *  销售流向查询接口
     * @return
     */
    public Map getFlowDataDirection(HnjxyyParam hnjxyyParam ) {
        Map map = new HashMap();
        map.put("output",hnjxyyParam.getOutput());
        map.put("owner",hnjxyyParam.getOwner());
        map.put("startDate",hnjxyyParam.getStartDate());
        map.put("endDate",hnjxyyParam.getEndDate());
        map.put("pagesize",hnjxyyParam.getPageSize());
        map.put("pageindex",hnjxyyParam.getCurrentPage());
        try {
            String url = Constants.SALE_FLOW_DIRECTION+"?access_token=" + hnjxyyParam.getAccessToken() ;
            String jsonObject = HttpUtil.HttpClientPost(url, map);
            Map resultMap = JSON.parseObject(jsonObject, Map.class);
            System.out.println("////"+ JSON.toJSON(resultMap));
            return resultMap;
        } catch (Exception e) {
            logger.info(e.getMessage(),e);
        }
        return null;
    }

    /***
     * 购进流向查询接口
     * @return
     */
    public Map gethnjxyPurchaseDirection(HnjxyyParam hnjxyyParam) {
        Map map = new HashMap();
        map.put("output",hnjxyyParam.getOutput());
        map.put("owner",hnjxyyParam.getOwner());
        map.put("startDate",hnjxyyParam.getStartDate());
        map.put("endDate",hnjxyyParam.getEndDate());
        try {
            String url = Constants.PURCHASE_FLOW_DIRECTION+"?access_token=" + hnjxyyParam.getAccessToken() ;
            String jsonObject = HttpUtil.HttpClientPost(url, map);
            Map resultMap = JSON.parseObject(jsonObject, Map.class);
            System.out.println("////"+ JSON.toJSON(resultMap));
        } catch (Exception e) {
            logger.info(e.getMessage(),e);
        }
        return null;
    }

    /***
     * 当前库存查询接口
     * @return
     */
    public Map getStockDirection(HnjxyyParam hnjxyyParam ) {
        Map map = new HashMap();
        map.put("output",hnjxyyParam.getOutput());
        map.put("owner",hnjxyyParam.getOwner());
        try {
            String url = Constants.STOCK_FLOW_DIRECTION+"?access_token=" + hnjxyyParam.getAccessToken() ;
            String jsonObject = HttpUtil.HttpClientPost(url, map);
            Map resultMap = JSON.parseObject(jsonObject, Map.class);
            System.out.println("////"+ JSON.toJSON(resultMap));
        } catch (Exception e) {
            logger.info(e.getMessage(),e);
        }
        return null;
    }

    /***
     * 品种信息查询接口
     * @return
     */
    public Map getProductsDirection(HnjxyyParam hnjxyyParam ) {
        Map map = new HashMap();
        map.put("output",hnjxyyParam.getOutput());
        try {
            String url = Constants.PRODUCTS_FLOW_DIRECTION+"?access_token=" + hnjxyyParam.getAccessToken() ;
            String jsonObject = HttpUtil.HttpClientPost(url, map);
            Map resultMap = JSON.parseObject(jsonObject, Map.class);
            System.out.println("////"+ JSON.toJSON(resultMap));
        } catch (Exception e) {
            logger.info(e.getMessage(),e);
        }
        return null;
    }
}
