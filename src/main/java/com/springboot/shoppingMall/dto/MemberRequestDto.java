package com.springboot.shoppingMall.dto;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberRequestDto {

    private String email;
    private String password;

}
