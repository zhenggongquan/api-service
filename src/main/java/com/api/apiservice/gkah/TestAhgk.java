package com.api.apiservice.gkah;

import com.alibaba.fastjson.JSON;
import com.api.apiservice.gkah.http.DecryptResult;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class TestAhgk {

    public static void main(String[] args) throws Exception {
        WebDDIServiceSoap_PortType webDDIServiceLocator = (WebDDIServiceSoap_PortType) new WebDDIServiceLocator().
                getPort(WebDDIServiceSoap_PortType.class);
        Map<String, Object> params = new HashMap<>(35);
        params.put("token", "qyfr1c3epstm7bw02gn8jk6a5xdh94vzi");
        params.put("userid", "00276-01");
        params.put("password", "00276-01");
        params.put("begindate", "2019/09/09");
        params.put("enddate", "2019/10/29");
        params.put("isfilter", "0");
//        String s = webDDIServiceLocator.webDDI_GetTokenInfo(JSON.toJSONString(params));
        String encrypt = webDDIServiceLocator.webDDI_GetPurBill(JSON.toJSONString(params));
        System.out.println(">>:"+ JSON.toJSONString(encrypt));
        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCdoxOGlLvWuaMwxgEUM6svF1EOX8UaN5CXeBi3pQI9pdqOhIrOz8uwzjlFXPSHvslT0BXl1x7QkJruG7Qgy0Sntp0TuduRA44d4XyicQ+qmQ/9eOUMKxHIMVAdSQKQ0TPEqnNRhoilsvLVql6vfbiQgNpynZ6M+NeZ2qkEqXU9MecKjD0xolt0g0fWOj/egOg9Juxi+u3C7mYw8BUWkHyRrwPGptAOpL8uVJIEsWOLIlIEcA4gnsEFaY3VfL8BpbjGzzdBkkK096Iv32mYDBXA9DSq7a77soRD4hCYKDSJw67ffIH4n4VJ+UPvsinR9DW2c+/4rSY4lZpgru46lWydAgMBAAECggEBAIf6J9mrauyqbU6hPkUC3ONeJZlUm10mGR/PhOLE/83Vx1Wwl1wWewokmdpveK+vr1MQ6BK/IeGfG0XRt+uh67MQHybo57GLc4fq/evRw0XRiq2HH20Dqe8aOpVIaWIqU5GNxrPIbQ8h8b7Fm6+drxtXSxgbRq0r6i7ZI3rWAj+p9U5pG4u6ri+smX9mmrpdqEM7YjtTqlaoehiIx8PfHkGdb6qvoCX8SGEtj462+Uu615y8syMQ39n1oD76JJBIwoRqlbz/5ISXltR9ST/VQGu9bjD27GfAhGFq0H/YdR0GcFY7Nv6mCKIOfq0IWxdLJZq9MPh/mHTTi43SUZydujECgYEA0efLnfqCBsu7VG4Uw9ZElmwqDSI5TcpDcv1fnRYJQ3ymKWnwwHfZ5NBQLxiXoL1DRj+wi7KQLhtadZepfV03Tn2IwflTq3fb2fc0jjNfP1WGXxq3bdDVLriJ8fjar8a1rxcIyVZGrvt2FNw6k14A1kGpICXFSRp/EWSkpIRTEOcCgYEAwEDrN2JafCLon1wLyiuE7N1zma8vxDAnuz5rY4fcOHspICvqjzqAYIvj4yEblyNZUORfgf8J1UBvqqa6g+i7WWYks+KCzMMmIKt9PS8Hg2Z+ZkMmx4EQLbQjx9iOQJyZ+aOzlZgNxwlXJXW4Sf8yuvUv58MuNnhdytuN0EhwcdsCgYB7q/t+/7qecGjV7OnVHKhajC4WgOSMXbBxzrEH55Tbq1RnMCEF9VdvBgFITlAAB6Lcf+fv1uw2Di20/P+Cemp8l1/9EX5nl330JT9UzRXARg6eeCo8zH7eQSIdbAbE6+nd2E93+Jo6vLOsxLjKXOdXVWZlJ3vef3sAb3DF8aTTXwKBgQChlW6crBN1BjoRxmE6WH1uP2ornyw8bmTWYU4M52FWL12PZpnMK9U+UBUHDwqLavBkpq0HK33uOCwid+OHfpIIP2tVrWlWBCcFilzGkcJ01C4kcQgk4frhDuiLzR0yfOyE/uuvLY9W3CjcmSZ9Ovo+XFkZJ9ite1kJaKK2jkvDxQKBgCbwN3wL5HQLi78YRuITuQpbWn9GIpVthnIswuoHnsvJ/SdTDkr87d26a+a+jQN0+wIaaqXF4gKqx3NGa5GRoioFXBpStFmE+YhKsm5aSDMPXtMQHWZaKX1dnxXTeK3bvc6MP2XNAlirboS2kH74hoVOykqtyzoVsRg/VJwFggvA";
//        String decrypt = TestDecryptResult.decrypt(encrypt, privateKey);
        String decrypt = TestRsA.realDecrypt(encrypt, privateKey);
        System.out.println(">>:"+ decrypt);


    }
}
