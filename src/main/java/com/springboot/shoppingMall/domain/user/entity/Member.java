package com.springboot.shoppingMall.domain.user.entity;

import com.springboot.shoppingMall.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //Mysql
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //H2
    private Long memberSeq;

    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String email;

    //enum
    @Enumerated(EnumType.STRING)
    @Column
    private MemberRole memberRole;

    @Column
    private boolean validation;

    @Column
    private String nickname;

    @Column
    private int loginFailCount;

    @OneToMany(mappedBy = "member")
    private List<MemberAuthentication> authentications;

    @Builder
    public Member(String id, String password, String email,
                  MemberRole memberRole, String nickname, boolean validation, int loginFailCount){
        this.id = id;
        this.password = password;
        this.email = email;
        this.memberRole = memberRole;
        this.nickname = nickname;
        this.validation = validation;
        this.loginFailCount = loginFailCount;
    }


}
