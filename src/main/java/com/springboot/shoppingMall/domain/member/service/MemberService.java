package com.springboot.shoppingMall.domain.member.service;

import com.springboot.shoppingMall.common.Encrypt;
import com.springboot.shoppingMall.domain.member.entity.Member;
import com.springboot.shoppingMall.domain.member.entity.MemberRepository;
import com.springboot.shoppingMall.dto.MemberRequestDto;
import com.springboot.shoppingMall.dto.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(MemberSaveDto dto){

        if(memberRepository.findByEmail(dto.getEmail()) != null){
            throw new IllegalArgumentException("이미 가입되어있는 회원입니다.");
        }else{
            Member request = new Member(dto);
            return memberRepository.save(request).getMemberSeq();
        }
    }

    public boolean login(MemberRequestDto dto, HttpServletRequest request){

        HttpSession session = request.getSession();

        Member member = memberRepository.findByEmail(dto.getEmail());
        String saltKey = member.getSaltKey();

        log.info("user password = {}", member.getPassword());
        log.info("input password pure = {}", dto.getPassword(), saltKey);
        log.info("input password enc1 = {}", Encrypt.SHA512(dto.getPassword(), saltKey));
        log.info("input password enc2 = {}", Encrypt.SHA512(dto.getPassword(), saltKey));
        log.info("input password enc3 = {}", Encrypt.SHA512(dto.getPassword(), saltKey));
        log.info("isEqual = {}", member.getPassword().equals(Encrypt.SHA512(dto.getPassword(), saltKey)));


        if(member == null){
            log.info("login result = null");
            throw new IllegalArgumentException("아이디를 확인해 주세요.");
        }
        //login success
        else if(member.getPassword().equals(Encrypt.SHA512(dto.getPassword(), saltKey))){
            log.info("login result = success");
            session.setAttribute("userName", member.getNickname());
            session.setAttribute("userSeq", member.getMemberSeq());
            return true;
        }
        //login fail
        else {
            log.info("login result = fail");
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

}
