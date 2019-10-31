package com.api.apiservice.gkgzWebService.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

public class DateUtil {

    /**
     * 获取多少天之前的日期
     * @param date
     * @param day
     * @author net
     * @since 2019-10-27 18:54:15
     */
    public static String getBeforeDate(String date,int day){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.parse(date, formatter);
        now = now.minus(day, ChronoUnit.DAYS);
        return now.toString();
    }

    public static void main(String[] args) {
        getBeforeDate("2019-10-26",90);
    }

}
