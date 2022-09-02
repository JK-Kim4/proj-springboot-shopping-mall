package com.springboot.shoppingMall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/web/index")
    public String webIndex(){

        return "/web/index";
    }

    @GetMapping("/web/login")
    public String webLogin(){
        return "/web/contents/member/login";
    }

    @GetMapping("/web/signup")
    public String webSignup(){
        return "/web/contents/member/registration";
    }

}
