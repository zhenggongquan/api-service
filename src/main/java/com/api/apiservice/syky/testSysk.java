package com.api.apiservice.syky;

import com.alibaba.fastjson.JSON;
import java.rmi.RemoteException;
public class testSysk {
	public static void main(String[] args) throws RemoteException {
		ServiceSoapProxy queryServiceProxy = new ServiceSoapProxy();
		String resultXml = queryServiceProxy.getPurchaseInfo("123456","123456",
				"2019-10-10","2018-10-10");
		System.out.printf("result:"+ JSON.toJSON(resultXml));
	}
}
