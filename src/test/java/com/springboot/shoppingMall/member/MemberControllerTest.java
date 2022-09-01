package com.springboot.shoppingMall.member;

import com.springboot.shoppingMall.domain.member.entity.Member;
import com.springboot.shoppingMall.domain.member.entity.MemberRepository;
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
    MemberRepository repository;

    @Test
    public void test(){

        String id = "test";
        String passwd = "test";

        Member mem = Member.builder()
                .id(id)
                .password(passwd)
                .build();

        repository.save(mem);

        List<Member> memberList = repository.findAll();

        Member result = memberList.get(0);
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getPassword()).isEqualTo(passwd);


    }
}
