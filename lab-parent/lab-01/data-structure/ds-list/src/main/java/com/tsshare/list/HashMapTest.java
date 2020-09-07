package com.tsshare.list;

import java.util.HashMap;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: TODO
 * @date : 2020-09-02 17:01
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap map =new HashMap();
        String key ="1";
        int i = key.hashCode();
        int n = 49&(16-1);
        System.out.println(i+"对应数组位置: "+n);
        map.put(key,"1");

        int a  =1>>2;
        System.out.println(a);


    }
}
