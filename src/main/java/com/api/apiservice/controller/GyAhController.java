package com.api.apiservice.controller;

import com.api.apiservice.gkah.http.AnhuiApiTask;
import com.api.apiservice.gyyn.GkYnApiTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  国控安徽
 */
@RestController
@RequestMapping("/gkah")
public class GyAhController {

    @Autowired
    AnhuiApiTask   AnhuiApiTask;
    /***
     *
     * @param request
     * @param response
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String getData(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam  String endDate) {
        return AnhuiApiTask.upLoadFile(endDate);
    }
}
