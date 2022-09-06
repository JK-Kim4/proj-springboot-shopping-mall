package com.springboot.shoppingMall.domain.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/hello")
    public String helloMember(){
        return "Hello Member";
    }

    @GetMapping("/signUp")
    public String singUp(){
        return "/web/contents/member/registration";
    }


}
