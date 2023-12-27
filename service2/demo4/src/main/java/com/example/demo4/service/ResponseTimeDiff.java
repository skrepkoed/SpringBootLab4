package com.example.demo4.service;



import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ResponseTimeDiff {
    public static String diff(String systemTime){
        Date now= new Date();
        Date timeInService1=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            timeInService1=format.parse(systemTime);    
        } catch (Exception e) {
           
        }
        
        long diffInMilliseconds = Math.abs(now.getTime() - timeInService1.getTime());
        
        return ""+diffInMilliseconds;
    }
}
