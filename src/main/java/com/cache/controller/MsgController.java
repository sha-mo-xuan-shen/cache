package com.cache.controller;

import com.cache.service.MsgSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    MsgSerice msgSerice;

    @GetMapping("/{tele}")
    public String getTele(@PathVariable String tele){
        return msgSerice.get(tele);
    }

    @PostMapping
    public boolean checkCode(String tele,String code){
        return msgSerice.check(tele, code);
    }

}
