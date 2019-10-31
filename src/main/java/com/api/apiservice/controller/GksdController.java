package com.api.apiservice.controller;

import com.api.apiservice.shandong.ShanDongApiTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 国控山东
 */
@RestController
@RequestMapping("/shandong")
public class GksdController  {

    @Autowired
    ShanDongApiTask shanDongApiTask;
    /***
     * 采购、入口
     * @param request
     * @param response
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam  String endDate) {
        return shanDongApiTask.upLoadFile(endDate);
    }


    /***
     * 销售
     * @param request
     * @param response
     */
    @RequestMapping("/uploadSale")
    @ResponseBody
    public String uploadSale(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam  String endDate) {
        return shanDongApiTask.uploadSale(endDate);
    }

}
