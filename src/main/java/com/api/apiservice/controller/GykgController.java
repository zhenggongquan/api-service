package com.api.apiservice.controller;

import com.api.apiservice.gyyn.GkYnApiTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  国控云南
 */
@RestController
@RequestMapping("/gykg")
public class GykgController {

    @Autowired
    GkYnApiTask gkYnApiTask;
    /***
     *
     * @param request
     * @param response
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String getData(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam  String endDate) {
        return gkYnApiTask.upLoadFile(endDate);
    }
}
