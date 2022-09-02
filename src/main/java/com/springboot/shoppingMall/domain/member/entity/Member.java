package com.springboot.shoppingMall.domain.member.entity;

import com.springboot.shoppingMall.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class Member extends BaseTimeEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //Mysql
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //H2
    @Column(name = "MEMBER_SEQ")
    private Long memberSeq;

    @Column
    private String email;

    @Column
    private String password;

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

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberAuthentication> authentications = new ArrayList<MemberAuthentication>();

    @Builder
    public Member(String password, String email,
                  MemberRole memberRole, String nickname, boolean validation, int loginFailCount){
        this.password = password;
        this.email = email;
        this.memberRole = memberRole;
        this.nickname = nickname;
        this.validation = validation;
        this.loginFailCount = loginFailCount;
    }


}
