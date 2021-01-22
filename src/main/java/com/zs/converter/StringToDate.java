package com.zs.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//String类型转化为Date类型的自定义转化器
public class StringToDate implements Converter<String, Date> {
    public Date convert(String s) {
        Date date=null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
             date= format.parse(s);
        }catch (ParseException p){
            p.printStackTrace();
        }
        return date;
    }
}
