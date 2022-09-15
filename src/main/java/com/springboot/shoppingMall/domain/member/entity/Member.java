package com.springboot.shoppingMall.domain.member.entity;

import com.springboot.shoppingMall.common.Encrypt;
import com.springboot.shoppingMall.domain.BaseTimeEntity;
import com.springboot.shoppingMall.dto.MemberSaveDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

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

    @Column
    private String saltKey;

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

/*    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberAuthentication> authentications = new ArrayList<MemberAuthentication>();*/

    @Builder
    public Member(String password, String email,
                  MemberRole memberRole, String nickname, boolean validation, int loginFailCount){
        String saltKey = Encrypt.getSalt();
        this.email = email;
        this.saltKey = saltKey;
        this.password = Encrypt.SHA512(password, saltKey);
        this.memberRole = memberRole;
        this.nickname = nickname;
        this.validation = validation;
        this.loginFailCount = loginFailCount;
    }

    @Builder
    public Member(MemberSaveDto dto){
        String saltKey = Encrypt.getSalt();
//        String saltKey = "LkYznIVZpsXKlAQWlorWhg==";
        this.email = dto.getEmail();
        this.saltKey = saltKey;
        this.password = Encrypt.SHA512(dto.getPassword(), saltKey);
        this.nickname = dto.getName();
        this.memberRole = MemberRole.ROLE_CLIENT;
        this.validation = true;
        this.loginFailCount = 0;

    }


}
