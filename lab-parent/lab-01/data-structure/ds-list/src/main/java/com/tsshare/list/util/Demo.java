package com.tsshare.list.util;

import org.springframework.util.Assert;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: TODO
 * @date : 2020-06-15 14:37
 */
public class Demo {
    public static void main(String[] args) {
        int a =15 & 1;
        int a1 =0b101;
        String tenToTwo = NumConvert.tenToanyHexNumber(15, 2);
        String tenToTwo1 = NumConvert.tenToanyHexNumber(1, 2);
        System.out.println(tenToTwo +":"+ tenToTwo1);
        System.out.println(a);

        int tsix =0x7FFFFFFF;
        System.out.println(tsix);

        String test ="f2caead6-c481-42a4-a50d-f6f38736a9dc";
        System.out.println(test.hashCode());
        Assert.isTrue(test.hashCode()==1521816749,"object hashcode" );
    }
}
