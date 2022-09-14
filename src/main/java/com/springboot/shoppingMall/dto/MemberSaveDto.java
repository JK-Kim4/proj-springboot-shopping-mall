package com.springboot.shoppingMall.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberSaveDto {

    private String email;
    private String password;
    private String name;
}
