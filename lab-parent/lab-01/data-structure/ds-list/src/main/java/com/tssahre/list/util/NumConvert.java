package com.tssahre.list.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: TODO
 * @date : 2020-06-15 14:58
 */
public class NumConvert {

    /**
     * 十进制转化为某一个进制数
     *
     * @param tenNumber 需要被转化的十进制的数字
     * @param hexNumber 需要转化的进制数字
     */

    public static String tenToanyHexNumber(int tenNumber, int hexNumber) {

        List<String> list = new ArrayList<String>();

        while (tenNumber / hexNumber != 0) {

            int aa = tenNumber % hexNumber;//获取求余的数字


            list.add(String.valueOf(aa));

            tenNumber = tenNumber / hexNumber;//获取除去进制数后的数，看是都还以为被除

        }


        list.add(String.valueOf(tenNumber));//将最后一个数添加进入集合

        String endHexNumber = "";

        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {

            endHexNumber = endHexNumber + list.get(i);

        }

        return endHexNumber;

    }

}
