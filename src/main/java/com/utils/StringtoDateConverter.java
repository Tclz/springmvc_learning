package com.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringtoDateConverter implements Converter<String, Date> {
    /**
     *
     * @param s 字符串参数
     * @return  日期对象
     */
    @Override
    public Date convert(String s) {
        if(s==null){
            throw new RuntimeException("无输入参数");
        }
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        // 字符串转日期
        try {
            return df.parse(s);
        }catch (Exception e){
            throw new RuntimeException("数据转换出错");
        }

    }
}
