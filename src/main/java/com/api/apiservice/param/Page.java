package com.api.apiservice.param;

import java.io.Serializable;

public class Page <T> implements Serializable {

    private int pageSize = 10;
    private int currentPage =1 ;
    private int totalPage = 1;
    private T record ;
    private int count;

    public Page() {
    }
    public Page(int pageSize,int currentPage) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }
    public Page(int pageSize, int currentPage, int count) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.count = count;
    }
    public int totalPage(){
        if (count % pageSize == 0) {
            totalPage  = count/pageSize;
        } else {
            totalPage = count/pageSize + 1;
        }
        return totalPage;
    }

    public static void main(String[] args) {
        Page page = new Page(50,1,501);
        System.out.println(".."+ page.totalPage);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }
}
