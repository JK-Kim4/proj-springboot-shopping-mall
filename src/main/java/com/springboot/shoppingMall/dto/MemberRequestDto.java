package com.springboot.shoppingMall.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberRequestDto {

    private String email;
    private String password;

    @Builder
    public MemberRequestDto(String email, String password){
        this.email = email;
        this.password = password;
    }

}
