package com.springboot.shoppingMall.domain.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member/api")
public class MemberApiController {

    @PostMapping("/send/validation")
    @ResponseBody
    public String sendValidation(){
        return null;
    }

}
