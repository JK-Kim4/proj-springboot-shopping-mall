package com.boiling.kidduramu.domain.user.oauth.dto;

import com.boiling.kidduramu.domain.user.domain.Role;
import com.boiling.kidduramu.domain.user.domain.User;
import lombok.Getter;

import java.io.Serializable;

/*
* 사용자 관리 위한 객체 ( 세션 정보 )
* */
@Getter
public class SessionUser implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String picture;
    private Role role;


    public SessionUser(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.role = user.getRole();
    }
}
