package com.springboot.shoppingMall.member;

import com.springboot.shoppingMall.common.Encrypt;
import com.springboot.shoppingMall.domain.member.entity.Member;
import com.springboot.shoppingMall.domain.member.entity.MemberRepository;
import com.springboot.shoppingMall.dto.MemberRequestDto;
import com.springboot.shoppingMall.dto.MemberSaveDto;
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


    @After
    public void cleanUp(){
        memberRepository.deleteAll();
    }

    @Test
    public void member_등록테스트(){

        //given
        String id = "test";
        String passwd = "test";
        Member mem = Member.builder()
                .password(passwd)
                .build();
        memberRepository.save(mem);

        //when
        List<Member> memberList = memberRepository.findAll();

        //then
        Member result = memberList.get(0);
        assertThat(result.getPassword()).isEqualTo(passwd);

    }

    @Test
    public void member_이메일_조회_테스트(){

        //given
        String testEmail = "testmail";
        MemberSaveDto dto = MemberSaveDto.builder()
                .email(testEmail)
                .password("1234")
                .name("tester")
                .build();
        Member request = new Member(dto);
        memberRepository.save(request);

        //when
        Member findMamber = memberRepository.findByEmail(testEmail);

        //then
        assertThat(findMamber.getEmail()).isEqualTo(testEmail);

    }

    @Test
    public void 회원로그인_테스트(){

        String email = "test@naver.com";
        String password = "1234";

//        String encKey = "LkYznIVZpsXKlAQWlorWhg==";

                //given
                MemberSaveDto dto = MemberSaveDto.builder()
                .email(email)
                .password(password)
                .name("test")
                .build();

        Member m = new Member(dto);

        long result = memberRepository.save(m).getMemberSeq();

        Member testMem = memberRepository.findByEmail(email);

        System.out.println("insert member data All = " +testMem.toString());
        System.out.println("insert member data salt key = " +testMem.getSaltKey());

        //when

        MemberRequestDto dto2 = MemberRequestDto.builder()
                .email(email)
                .password(password)
                .build();

        //then
        System.out.println("login member enc password = " +Encrypt.SHA512(password, testMem.getSaltKey()));
        System.out.println("insert member enc password = " +testMem.getPassword());


        assertThat(testMem.getPassword()).isEqualTo(Encrypt.SHA512(password, testMem.getSaltKey()));

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
