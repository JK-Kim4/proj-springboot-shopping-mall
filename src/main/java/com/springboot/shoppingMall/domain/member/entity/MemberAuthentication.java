package com.springboot.shoppingMall.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class MemberAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //H2
    @Column(name = "MEMBER_AUTHENTICATION_SEQ")
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "MEMBER_SEQ")
    private Member member;

    @Column
    private String authenticationKey;

    @Column
    private LocalDateTime expiredDate;

    @Builder
    public MemberAuthentication(Member member, String authenticationKey, LocalDateTime expiredDate){
        this.member = member;
        this.authenticationKey = authenticationKey;
        this.expiredDate = expiredDate;
    }

    public void setMember(Member member){
        this.member = member;

        if(!member.getAuthentications().contains(this)){
            member.getAuthentications().add(this);
        }
    }

}
