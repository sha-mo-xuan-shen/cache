package com.cache.service.impl;

import com.cache.domain.SMSCode;
import com.cache.service.SMSCodeService;
import com.cache.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    CodeUtils codeUtils;

    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        cacheChannel.set("sms",tele,code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = cacheChannel.get("sms",smsCode.getTele()).asString();
            return code.equals(smsCode.getCode());

    }


}
