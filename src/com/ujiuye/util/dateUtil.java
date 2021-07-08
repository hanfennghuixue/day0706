package com.ujiuye.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateUtil {

//字符串日期转date
    public   static Date strTranFerDate(String date, String pattern) {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date dat = null;
        try {
            dat = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dat;
    }


}