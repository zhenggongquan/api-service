package com.api.apiservice.shandong;
import com.api.apiservice.shandong.util.RSAUtil;
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
            Document document = DocumentHelper.parseText(encrypt);
            Element root = document.getRootElement();
            String secretTimeText = root.getText();
            decrypt = RSAUtil.decrypt(secretTimeText, privateKey);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return decrypt;
    }
}
