package com.api.apiservice.gkah.http;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author John
 **/
public class DecryptResult {

    public static String decrypt(String encrypt, String privateKey) {
        String decrypt = "";
        try {
//            Document document = DocumentHelper.parseText(encrypt);
//            Element root = document.getRootElement();
//            String secretTimeText = root.getText();
//            decrypt = com.api.apiservice.gkah.http.RSAUtil.decrypt(secretTimeText, privateKey);
            decrypt = com.api.apiservice.gkah.http.RSAUtil.decrypt(encrypt, privateKey);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return decrypt;
    }
}
