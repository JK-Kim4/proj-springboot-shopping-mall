package com.springboot.shoppingMall.domain.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/hello")
    public String helloMember(){
        return "Hello Member";
    }

    /*회원 가입 인증키 발급*/
    @GetMapping("/issue/authkey")
    @ResponseBody
    public String issueAuthKey(String email){

        
        return null;
    }


}
