package com.api.apiservice.axze;

import com.alibaba.fastjson.JSON;
import java.rmi.RemoteException;
import java.util.Map;

public class TestAxze {
    public static void main(String[] args) throws RemoteException {
        QueryServiceProxy queryServiceProxy = new QueryServiceProxy();
        String resultXml = queryServiceProxy.queryService("DWI00000839",
//                "axze.purchase.stock.in",
                "axze.sell.stock.out",
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<param>\n" +
                        "<startdate>2019-07-10</startdate>\n" +
                        "<keyword></keyword>\n" +
                        "<pagesize>" +50+ "</pagesize>\n" +
                        "<pageindex>" +1+ "</pageindex>\n" +
                        "</param>",
                "18d06e052bad6b96820a5a8ff4cb3c9b");

        Map map = XMLUtilDoc.xmlElements(resultXml);
        System.out.printf("result:"+ JSON.toJSON(map));
    }
}
