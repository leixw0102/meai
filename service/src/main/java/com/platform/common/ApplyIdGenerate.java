package com.platform.common;

import java.util.Date;
import java.util.Random;

/**
 * Created by ehl on 2016/6/5.
 */
public class ApplyIdGenerate {
    final  static Random random = new Random(1000000);
    public static String getDefaultApplyId(){
        return Md5Func.md5(("haier"+new Date().getTime()+ random.nextLong()).getBytes());
    }

    public static String getApplyId(String userId){
        return Md5Func.md5(("haier"+new Date().getTime()+userId).getBytes());
    }

    public static void main(String[]args){
        System.out.println(getDefaultApplyId());
    }
}
