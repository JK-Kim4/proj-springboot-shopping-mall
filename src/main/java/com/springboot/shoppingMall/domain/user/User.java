package com.springboot.shoppingMall.domain.user;

import com.springboot.shoppingMall.domain.BaseTimeEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //Mysql
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //H2
    private Long seq;

    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String email;

    //enum
    @Column
    private String userRole;

    @Column
    private boolean validation;

    @Column
    private String nickname;

    @Column
    private int loginFailCount;


}
