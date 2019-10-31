package com.api.apiservice.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 类名称: CsvUtil
 * 类描述: 文件操作
 * 创建人:
 * Version 1.0.0
 */
public class CsvUtil {

    public static File makeTempCSV(String fileDir ,String fileName, List heads, List<List> values) throws IOException {
         //创建文件
        String path = ClassLoader.getSystemResource("").getPath();
        File file0 = new File(path + fileDir);
        if(!file0.exists()){
            file0.mkdir();
        }
        File file = new File(file0.getAbsolutePath()+"\\" + fileName + ".csv");
        CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator("\n");
        FileOutputStream fos =new FileOutputStream(file);
        byte[] uft8bom = {(byte)0xef,(byte)0xbb,(byte)0xbf};
        fos.write(uft8bom);
        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
        CSVPrinter printer =null;
        try {
            printer = new CSVPrinter(bufferedWriter, formator);
            //写入表头
            printer.printRecord(heads);
            //写入内容
            for (List value : values) {
                printer.printRecord(value);
            }
            printer.flush();
        }finally {
            printer.close();
            bufferedWriter.close();
        }
        return file;
    }

    public static void appendFileCsv(File file, List<List> content) {
        if(content !=null && !content.isEmpty()) {
            CSVPrinter printer = null;
            BufferedWriter bufferedWriter = null;
            try {
                CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator("\n");
                bufferedWriter =
                        new BufferedWriter(new OutputStreamWriter
                                (new FileOutputStream(file, true), "UTF-8"));
                printer = new CSVPrinter(new FileWriter(file, true), formator);
                //写入内容
                for (List value : content) {
                    printer.printRecord(value);
                }
                printer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    printer.close();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        List heads = new ArrayList();
        heads.add("taxrate");
        heads.add("goodname");
        heads.add("quantity");
        List<List> values=    new ArrayList<>();
        List<String> list =  new ArrayList<>();
        List<String> list2 =  new ArrayList<>();
        list.add("中国馆");
        list.add("饿哦萨芬");
        list.add("粉色分");
        list2.add("法尔");
        list2.add("会突然");
        list2.add("据就");
        values.add(list);
        values.add(list2);
        File file =  makeTempCSV ("shandong","销售单",heads,values);
        List<List> values2=    new ArrayList<>();
        List<String> list1 =  new ArrayList<>();
        List<String> list22 =  new ArrayList<>();
        list1.add("中国馆2");
        list1.add("饿哦萨芬3");
        list1.add("粉色分3");
        list22.add("法尔3");
        list22.add("会突然3");
        list22.add("据就3");
        values2.add(list1);
        values2.add(list22);
        appendFileCsv(file.getAbsoluteFile(),values2);

//        String path = ClassLoader.getSystemResource("").getPath();
//        File file0 = new File(path+"shandong");
//        if(!file0.exists())
//            file0.mkdir();
//        System.out.println(file0.getAbsolutePath());

    }

}