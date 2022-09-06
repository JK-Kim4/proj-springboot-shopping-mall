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
    public boolean sendValidation(String email){
        HashMap<String, Object> param = new HashMap<>();

        log.debug("MemberApiController@sendValidation = {}", email);


        param.put("receiver", "jongbell4@gmail.com");
        param.put("title", "인증번호");
        param.put("content", "12345");

        return MailSender.sendMail(param);
    }

}
