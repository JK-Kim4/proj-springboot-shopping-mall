package com.springboot.shoppingMall.common;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

@Slf4j
public class Encrypt {

    //암호화 난수값 생성
    public static String getSalt(){
        String salt = null;
        try{
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            byte[] bytes = new byte[16];
            random.nextBytes(bytes);
            salt = new String(Base64.getEncoder().encode(bytes));
        }catch (Exception e){
            log.error("get salt error", e);
        }
        return salt;
    }

    public static String SHA512(String password,  String hash){
        String hex = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(hash.getBytes());
            md.update(password.getBytes());
            hex = String.format("%128x", new BigInteger(1, md.digest()));
        }catch (Exception e){
            log.error("SHA512 error", e);
        }

        return hex;
    }
}
