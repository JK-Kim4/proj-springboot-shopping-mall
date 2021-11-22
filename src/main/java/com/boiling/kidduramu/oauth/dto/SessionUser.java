package com.boiling.kidduramu.oauth.dto;

import com.boiling.kidduramu.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/*
* 사용자 관리 위한 객체 ( 세션 정보 )
* */
@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;


    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
