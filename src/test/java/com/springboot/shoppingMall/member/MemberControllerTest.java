package com.springboot.shoppingMall.member;

import com.springboot.shoppingMall.domain.member.entity.Member;
import com.springboot.shoppingMall.domain.member.entity.MemberRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberControllerTest {

    @Autowired
    MemberRepository memberRepository;

//    @Autowired
//    MemberAuthenticationRepository memberAuthenticationRepository;

    @After
    public void cleanUp(){
        memberRepository.deleteAll();
//        memberAuthenticationRepository.deleteAll();
    }

    @Test
    public void member_등록테스트(){

        String id = "test";
        String passwd = "test";

        Member mem = Member.builder()
                .password(passwd)
                .build();

        memberRepository.save(mem);

        List<Member> memberList = memberRepository.findAll();

        Member result = memberList.get(0);
        assertThat(result.getPassword()).isEqualTo(passwd);

    }

//    @Test
//    public void member_auth_등록테스트(){
//        String id = "member01";
//        String pwd = "memberpwd";
//
//        memberRepository.save(Member.builder().password(pwd).build());
//
//        List<Member> memberList = memberRepository.findAll();
//        Member result = memberList.get(0);
//        Long memberSeq = result.getMemberSeq();
//        String key = "testkey";
//
//        System.out.println("insert member Seq : " + memberSeq);
//
//        memberAuthenticationRepository.save(MemberAuthentication.builder().member(result).authenticationKey(key).build());
//
//        List<MemberAuthentication> memberAuthenticationList = memberAuthenticationRepository.findAll();
//
//        MemberAuthentication resultAuth = memberAuthenticationList.get(0);
//
//        System.out.println("memberAuthentication@member = " + resultAuth.getMember().getMemberSeq());
//        System.out.println("memberAuthentication@member = " + memberSeq);
//
//        assertThat(memberSeq).isEqualTo(resultAuth.getMember().getMemberSeq());
//
//    }
}
