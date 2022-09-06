package com.springboot.shoppingMall.domain.member.controller;

import com.springboot.shoppingMall.common.MailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member/api")
public class MemberApiController {

    @PostMapping("/send/validation")
    @ResponseBody
    public String sendValidation(){
        HashMap<String, Object> param = new HashMap<>();
        MailSender.sendMail(param);
        return null;
    }

}
