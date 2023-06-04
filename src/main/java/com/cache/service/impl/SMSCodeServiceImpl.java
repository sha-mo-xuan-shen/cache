package com.cache.service.impl;

import com.cache.domain.SMSCode;
import com.cache.service.SMSCodeService;
import com.cache.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    CodeUtils codeUtils;

    @Override
    //取缓存
    // @Cacheable(value = "smscode",key = "#tele")
    //存缓存 return值为存储的value，参数为key
    @CachePut(value = "smscode",key = "#tele")
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        String cacheCode = codeUtils.get(smsCode.getTele());
        // return code.equals(cacheCode);
        return cacheCode.equals(code);
    }


}
