package com.api.apiservice.axze;

public class QueryServiceProxy implements  QueryService {
  private String _endpoint = null;
  private com.api.apiservice.axze.QueryService queryService = null;
  
  public QueryServiceProxy() {
    _initQueryServiceProxy();
  }
  
  public QueryServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initQueryServiceProxy();
  }
  
  private void _initQueryServiceProxy() {
    try {
      queryService = (new  com.api.apiservice.axze.SupplyInfoServiceLocator()).getQueryServicePort();
      if (queryService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)queryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)queryService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (queryService != null)
      ((javax.xml.rpc.Stub)queryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.api.apiservice.axze.QueryService getQueryService() {
    if (queryService == null)
      _initQueryServiceProxy();
    return queryService;
  }
  
  public String queryService(String orgCode, String operate, String param, String sign) throws java.rmi.RemoteException{
    if (queryService == null)
      _initQueryServiceProxy();
    return queryService.queryService(orgCode, operate, param, sign);
  }
  
  
}