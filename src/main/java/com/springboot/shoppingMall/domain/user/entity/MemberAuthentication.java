package com.springboot.shoppingMall.domain.user.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
public class MemberAuthentication {

    @Id
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "member_seq")
    private Member member;

    @Column
    private String authenticationKey;

    @Column
    private LocalDateTime expiredDate;
}
