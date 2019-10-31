/**
 * VendorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.api.apiservice.gkgzWebService;

public interface VendorService extends java.rmi.Remote {
    public StockInfo[] getStockInfo(String customID, String accessID, String accessPasswords) throws java.rmi.RemoteException, DDISoaFault;
    public PurchaseInfo[] getPurchaseInfo(String customID, String startDate, String endDate, String accessID, String accessPasswords) throws java.rmi.RemoteException, DDISoaFault;
    public StockInfo[] getRealTimeStockInfo(String customID, String accessID, String accessPasswords) throws java.rmi.RemoteException, DDISoaFault;
    public SaleInfo[] getSaleInfo(String customID, String startDate, String endDate, String accessID, String accessPasswords) throws java.rmi.RemoteException, DDISoaFault;
}
