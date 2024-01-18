package com.actsys.vo;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @desc:
 * @author: Ping
 * @date: 2023/12/12 10:05
 */

@Data
public class ActivityConditionVO {
    private int pageNumber ;
    private int pageSize ;
    private String keywords ;
    private String categoryId ;
    private String status ;


    public static void main(String args[]) {
        String input = "sql year = 12 Or --  and password = 123" ;
        String pattern = "\\s*(or | OR | oR | Or)\\s*--" ;
        Matcher matcher = Pattern.compile(pattern).matcher(input);
        System.out.println(matcher.find()) ;



    }

}
