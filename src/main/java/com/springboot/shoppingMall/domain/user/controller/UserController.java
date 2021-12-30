package com.springboot.shoppingMall.domain.user.controller;

import com.springboot.shoppingMall.domain.user.domain.LoginUser;
import com.springboot.shoppingMall.domain.user.domain.UserRepository;
import com.springboot.shoppingMall.domain.user.oauth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/detail")
    public String detail(@LoginUser SessionUser user, Model model){
        return "users/user-detail";
    }

    @DeleteMapping("/delete/{userId}")
    @ResponseBody
    public Long delete(@PathVariable Long userId){
        log.info("login user @ delete : " + userRepository.findById(userId).get().toString());

         userRepository.delete(userRepository.findById(userId).get());

         return userId;
    }
}
