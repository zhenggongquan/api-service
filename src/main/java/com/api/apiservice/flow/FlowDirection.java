package com.api.apiservice.flow;

public interface FlowDirection {
     public Object getFlowDataDirection(String access_token, String startDate, String endDate,
                            String owner,int pagesize, int pageindex);
}
