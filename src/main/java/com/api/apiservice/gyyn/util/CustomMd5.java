package com.api.apiservice.gyyn.util;

import com.api.apiservice.util.MD5Util;
import org.apache.commons.lang3.StringUtils;

public class CustomMd5 {
    public static String md5code(String code) {
        if (StringUtils.isNotBlank(code)) {
            return MD5Util.md5(code).toLowerCase().substring(3, 9) +
                    MD5Util.md5(code).toLowerCase().substring(19, 25);
        } else {
            return "";
        }
    }
}

