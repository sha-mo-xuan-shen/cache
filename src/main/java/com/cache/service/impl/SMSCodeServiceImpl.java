package com.cache.service.impl;

import com.cache.domain.SMSCode;
import com.cache.service.SMSCodeService;
import com.cache.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    CodeUtils codeUtils;

    @Autowired
    MemcachedClient memcachedClient;
    @Override
    //存取缓存
    // @Cacheable(value = "smscode",key = "#tele")
    //存缓存，只存不取，返回值为存储值
    @CachePut(value = "smscode",key = "#tele")
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        try {
            memcachedClient.set(tele,5,code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
            code = memcachedClient.get(smsCode.getTele()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code.equals(smsCode.getCode());
    }


}
