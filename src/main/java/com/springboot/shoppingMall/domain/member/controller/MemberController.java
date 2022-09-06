package com.springboot.shoppingMall.domain.member.controller;

import com.springboot.shoppingMall.common.CommonUtil;
import com.springboot.shoppingMall.common.MailSender;
import com.springboot.shoppingMall.domain.member.entity.Member;
import com.springboot.shoppingMall.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/hello")
    public String helloMember(){
        return "Hello Member";
    }

    @GetMapping("/signUp")
    public String singUp(){
        return "/web/contents/member/registration";
    }

    @PostMapping("/send/validation")
    @ResponseBody
    public boolean sendValidation(String email){
        HashMap<String, Object> param = new HashMap<>();
        String validation = CommonUtil.getRandomNumber(6);

        log.debug("MemberApiController@sendValidation = {}", email);


        param.put("receiver", "jongbell4@gmail.com");
        param.put("title", validation);
        param.put("content", "12345");

        return MailSender.sendMail(param);
    }

    @PostMapping("/signUp")
    @ResponseBody
    public Long signUp(@RequestBody Member member){
        return memberService.save(member);
    }


}
