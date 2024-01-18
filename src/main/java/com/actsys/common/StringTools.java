package com.actsys.common;

import org.apache.xmlbeans.impl.util.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @desc:
 * @author: Ping
 * @date: 2023/12/12 21:15
 */

public class StringTools {
    public static final String ENCODING = "utf-8" ;

    public static String decodeByBase64(String str) throws UnsupportedEncodingException {
        return new String(Base64.decode(str.getBytes(ENCODING)));
    }
}
