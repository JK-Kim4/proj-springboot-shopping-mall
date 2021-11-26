package com.boiling.kidduramu.web.controller;

import com.boiling.kidduramu.domain.user.LoginUser;
import com.boiling.kidduramu.oauth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        log.debug("index page");
        if(user != null){
            model.addAttribute("username", user.getName());
        }
        return "index";
    }
}
