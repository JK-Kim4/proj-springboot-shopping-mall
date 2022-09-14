package com.springboot.shoppingMall.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberSaveDto {

    private String email;
    private String password;
    private String name;

    @Builder
    public MemberSaveDto(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
