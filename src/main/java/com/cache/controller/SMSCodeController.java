package com.cache.controller;

import com.cache.domain.SMSCode;
import com.cache.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    SMSCodeService SCservice;

    @GetMapping
    public String getCode(String tele){
        String code = SCservice.sendCodeToSMS(tele);
        return code;
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode){
        return SCservice.checkCode(smsCode);
    }
}
