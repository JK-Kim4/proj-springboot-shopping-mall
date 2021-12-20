package com.springboot.shoppingMall.domain.user.oauth.dto;

import com.springboot.shoppingMall.domain.user.domain.Role;
import com.springboot.shoppingMall.domain.user.domain.User;
import lombok.Getter;

import java.io.Serializable;

/*
* 사용자 관리 위한 객체 ( 세션 정보 )
* */
@Getter
public class SessionUser implements Serializable {

    private Long userId;
    private String name;
    private String email;
    private String picture;
    private Role role;


    public SessionUser(User user){
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.role = user.getRole();
    }
}
