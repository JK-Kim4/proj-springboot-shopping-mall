package com.springboot.shoppingMall.domain.member.controller;

import com.springboot.shoppingMall.common.CommonUtil;
import com.springboot.shoppingMall.common.MailSender;
import com.springboot.shoppingMall.domain.member.entity.Member;
import com.springboot.shoppingMall.domain.member.service.MemberService;
import com.springboot.shoppingMall.dto.MemberSaveDto;
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
    public HashMap<String, Object> sendValidation(@RequestBody String email){
        log.info("MemberApiController@sendValidation = {}", email);
        HashMap<String, Object> param = new HashMap<>();
        HashMap<String, Object> result = new HashMap<>();
        String validation = CommonUtil.getRandomNumber(6);

        param.put("receiver", email);
        param.put("title", "인증번호 발송 메일");
        param.put("content", validation);

        result.put("result", MailSender.sendMail(param));
        result.put("valid", validation);

        return result;
    }

    @PostMapping("/signUp")
    @ResponseBody
    public Long signUp(@RequestBody MemberSaveDto dto){
        return memberService.save(dto);
    }


}
