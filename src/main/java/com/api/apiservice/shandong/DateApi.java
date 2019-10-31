package com.api.apiservice.shandong;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.apiservice.shandong.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author John
 * 获取客户服务器当前时间
 **/
public class DateApi {
    private static final Logger logger = LoggerFactory.getLogger(DateApi.class);
    private static final String SUCCESS_CODE = "0";

    public static String getDate (String url, String privateKey,  Map<String, String> params) {
        String now = LocalDateTime.now().toString();
        try {
            Map<String, String> requestParams = new HashMap<>(1);
            requestParams.put("input", JSON.toJSONString(params));
            String result = HttpClientUtil.doGet(url, requestParams);
            logger.info("国控山东获取时间接口返回值:{}", result);

            if (!StringUtils.isEmpty(result)) {
                logger.info("-----------------------解析时间XML开始------------------------");
                String decrypt = DecryptResult.decrypt(result, privateKey);
                logger.info("国控山东获取时间解密后的值: {}", decrypt);
                JSONObject jsonResult = JSON.parseObject(decrypt);
                Object code = jsonResult.get("Code");
                if (!StringUtils.isEmpty(code) && SUCCESS_CODE.equals(code)) {
                    JSONArray table = (JSONArray) jsonResult.get("Table");
                    if (null != table) {
                        JSONObject sdt = table.getJSONObject(0);
                        now = sdt.get("sdt").toString();
                        logger.info("国控山东服务器当前时间：{}", now);
                    }
                }
            }
        }catch (Exception e) {
            logger.error("获取客户服务器当前时间。");
            e.printStackTrace();
        }
        return now;
    }
}
