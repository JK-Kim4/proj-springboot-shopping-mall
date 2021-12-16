package com.springboot.shoppingMall.domain.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*사용자 객체 - 권한*/
@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "사용자"),
    SELLER("ROLE_SELLER", "판매자"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;

}
