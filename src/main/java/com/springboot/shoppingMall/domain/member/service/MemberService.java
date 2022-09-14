package com.springboot.shoppingMall.domain.member.service;

import com.springboot.shoppingMall.domain.member.entity.Member;
import com.springboot.shoppingMall.domain.member.entity.MemberRepository;
import com.springboot.shoppingMall.dto.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(MemberSaveDto dto){
        Member request = new Member(dto);
        return memberRepository.save(request).getMemberSeq();
    }

}
