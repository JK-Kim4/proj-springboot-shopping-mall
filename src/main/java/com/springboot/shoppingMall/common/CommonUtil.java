package com.springboot.shoppingMall.common;

import java.util.Random;

public class CommonUtil {

    public static String getRandomNumber(int length){

        Random rn = new Random();
        String result = "";

        for(int i = 0; i < length; i++){
            result += Integer.toString(rn.nextInt(10));
        }
        return result;
    }

}
