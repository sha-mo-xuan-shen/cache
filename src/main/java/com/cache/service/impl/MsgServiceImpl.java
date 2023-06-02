package com.cache.service.impl;

import com.cache.service.MsgSerice;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MsgServiceImpl implements MsgSerice {

    HashMap<String,String> cache = new HashMap<>();

    @Override
    public String get(String tele) {
        String code = tele.substring(tele.length()-6);
        cache.put(tele,code);
        return code;
    }

    @Override
    public Boolean check(String tele, String code) {
        String queryCode = cache.get(tele);
        return queryCode.equals(code);
    }
}
