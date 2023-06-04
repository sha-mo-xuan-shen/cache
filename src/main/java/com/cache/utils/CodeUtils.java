package com.cache.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {

    public String generator(String tele){

        int hash = tele.hashCode();
        int encryption = 20230602;
        long now = System.currentTimeMillis();
        long result = hash ^ now ^ encryption;
        long code = result % 1000000;
        code=code<0?-code:code;
        return String.format("%06d",code);
    }

    //返回值为null表示只取不存,一般对应一个CachePut
    @Cacheable(value = "smscode",key = "#tele")
    public String get(String tele){
        return null;
    }

//    public static void main(String[] args) {
//        for (int i=0;i<=20;i++){
//        // String code = ;
//        System.out.println(new CodeUtils().generator("114514"));
//        }
//    }
}
