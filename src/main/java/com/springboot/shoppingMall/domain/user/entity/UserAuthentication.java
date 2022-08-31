package com.springboot.shoppingMall.domain.user.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
public class UserAuthentication {

    @Id
    private Long seq;

    @Column
    private String authenticationKey;

    @Column
    private LocalDateTime expiredDate;
}
