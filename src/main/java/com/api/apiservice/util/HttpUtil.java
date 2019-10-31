package com.api.apiservice.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.apiservice.axze.QueryServiceProxy;
import com.api.apiservice.axze.XMLUtilDoc;
import com.api.apiservice.param.AxzeParam;
import com.api.apiservice.param.SykyParam;
import com.api.apiservice.syky.ServiceSoapProxy;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;


public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /***
     *  web service xml
     * @param
     * @return
     */
    public static Map AxzeXMLHttpPost(AxzeParam axzeParam) {
        try {
            QueryServiceProxy queryServiceProxy = new QueryServiceProxy();
            String resultXml = queryServiceProxy.queryService(
                    axzeParam.getOrgCode(),
                    axzeParam.getOperate(),
                    "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<param>\n" +
                    "<startdate>" + axzeParam.getStartdate() + "</startdate>\n" +
                    "<keyword>" + axzeParam.getKeyword() + "</keyword>\n" +
                    "<pagesize>" + axzeParam.getPageSize() + "</pagesize>\n" +
                    "<pageindex>" + axzeParam.getCurrentPage() + "</pageindex>\n" +
                    "</param>",
                    axzeParam.getSign());
            Map map = XMLUtilDoc.xmlElements(resultXml);
            return map;
        } catch (Exception e) {
            logger.error("调用异常....",e);
        }
        return null;
    }

    /***
     *  web service xml
     * @param
     * @return
     */
    public static Map SykyXMLHttpPost(SykyParam sykyParam) {
        try {
            ServiceSoapProxy queryServiceProxy = new ServiceSoapProxy();
            String resultXml = queryServiceProxy.getPurchaseInfo(sykyParam.getUserID(),sykyParam.getUserPwd(),
                    sykyParam.getBeginDate() ,sykyParam.getEndDate());
            System.out.printf("result:"+ JSON.toJSON(resultXml));
            Map map = XMLUtilDoc.xmlElements(resultXml);
            return map;
        } catch (Exception e) {
            logger.error("调用异常....",e);
        }
        return null;
    }

    /**
     * httpCLient发送get请求（带参数直接在ulr后跟参数即可）
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public static String HttpClientGet(String url, Map<String, String> map) throws Exception {
        //url=1287079?xin=09&name=1212&passworld=10
        if (map != null && map.size() > 0) {
            url = url + "?";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                url = url + mapKey + "=" + mapValue + "&";
            }
        }
        url = url.substring(0, url.length() - 1);
        logger.info("url:" + url);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse Response = client.execute(httpGet);
        try {
            // HttpEntity
            // 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
            // 所有的响应的数据，也全部都是封装在HttpEntity里面
            HttpEntity entity = Response.getEntity();
            // 通过EntityUtils 来将我们的数据转换成字符串
            return EntityUtils.toString(entity, "UTF-8");
        } finally {
            Response.close();
        }
    }

    /**
     * httpCLient发送POST请求（带参数直接在ulr后跟参数即可）
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public static String HttpClientPost(String url, Map<String, Object> map) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //  post带参数开始
        JSONObject postData = new JSONObject();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                postData.put(entry.getKey(),entry.getValue());
            }
        }
        StringEntity StringEntity = new StringEntity(postData.toString(),ContentType.APPLICATION_JSON);
        httpPost.setEntity(StringEntity);
        // HttpEntity在httpClient里面，所有的请求参数都是通过HttpEntity携带过去的
        CloseableHttpResponse response = client.execute(httpPost);
        try {
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity, "UTF-8");
            System.out.println("result :" + str);
            return str;
        }  finally {
            response.close();
        }
    }

    public static void main(String ars[]) throws Exception {
//        Map map = XMLHttpPost("http://222.175.123.206:9980/QueryService?wsdl","2019-10-23","1233456",10,1);
//        System.out.printf(":"+ JSON.toJSON(map));

//
//        Map map = new HashMap();
//        map.put("output","json");
//        map.put("owner","ZDA");
//        map.put("startDate","2019-09-0");
//        map.put("endDate","2019-09-30");
//        map.put("pagesize",50);
//        map.put("pageindex",1);
//        try {
//            String url = Constants.PRODUCTS_FLOW_DIRECTION+"?access_token=" + 123456 ;
//            String jsonObject = HttpUtil.HttpClientPost(url, map);
//            Map resultMap = JSON.parseObject(jsonObject, Map.class);
//            System.out.println("////"+ JSON.toJSON(resultMap));
//        } catch (Exception e) {
//            logger.info(e.getMessage(),e);
//        }
    }
}