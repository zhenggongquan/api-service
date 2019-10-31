package com.api.apiservice.gyyn;

import com.api.apiservice.gyyn.util.CustomMd5;
import com.api.apiservice.util.Constants;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class TestGyyn {

    public static void main(String[] args) throws RemoteException, ServiceException {
        XxdjWebServiceSoap_PortType xxdjWebServiceSoap12Stub = (XxdjWebServiceSoap_PortType) new XxdjWebServiceLocator()
                .getPort(XxdjWebServiceSoap_PortType.class);
        String tempCode2 =  xxdjWebServiceSoap12Stub.getTempCode("6050", "666666");
        System.out.println("返回值："+tempCode2);//返回值：1572328713986
        String resultCode  =CustomMd5.md5code(tempCode2 +"dyc56789");
        String selected = xxdjWebServiceSoap12Stub.selected("6050", "666666", Constants.GYYNCUSTOM_800002,
                "20191001", "20191031", resultCode);
        System.out.println("返回数据: "+selected);


    }
}
