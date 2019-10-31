package com.api.apiservice.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String  dateFormatter0 =  "yyyyMMdd";
    public static final String  dateFormatter1 =  "yyyy-MM-dd";
    public static final String  dateFormatter2 =  "yyyy/MM/dd";

    /***
     *
     * 获取给定时间的前90天时间
     * @param dateStr
     * @param formater
     * @return
     * @throws Exception
     */
    public static String coventDate(String dateStr,String formater) throws Exception {
        Calendar calc = Calendar.getInstance();
        calc.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr));
        calc.add(calc.DATE, -90);
        Date minDate = calc.getTime();
        String minDateStr = new SimpleDateFormat(formater).format(minDate);
        return  minDateStr ;
    }

    /***
     *
     * @param dateStr  需要定位的日期
     * @param dataFormat 传入的日期格式
     * @param day       返回多少天的日期
     * @param resultFormat 返回的日期格式
     * @return
     * @throws Exception
     */
    public static String conventFormatDate(String dateStr,String dataFormat,int day,String resultFormat) throws Exception {
        Calendar calc = Calendar.getInstance();
        calc.setTime(new SimpleDateFormat(dataFormat).parse(dateStr));
        calc.add(calc.DATE, -day);
        Date minDate = calc.getTime();
        String minDateStr = new SimpleDateFormat(resultFormat).format(minDate);
        return  minDateStr ;
    }

    public static void main(String[] args) throws Exception {
//        System.out.println("1>"+DateUtil.conventFormatDate("2019-10-28",DateUtil.dateFormatter1,10,"yyyy-MM-dd HH"));
//        System.out.println("2>"+DateUtil.conventFormatDate("2019/10/28",DateUtil.dateFormatter2,10,"yyyy-MM-dd HH"));
//        System.out.println("3>"+DateUtil.conventFormatDate("20191028",DateUtil.dateFormatter0,10,"yyyy-MM-dd HH"));
    }
}
