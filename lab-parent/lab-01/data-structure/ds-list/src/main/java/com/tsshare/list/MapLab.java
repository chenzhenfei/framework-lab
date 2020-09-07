package com.tsshare.list;

import java.util.*;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: TODO
 * @date : 2020-06-15 16:11
 */
public class MapLab {

    public static void main(String[] args) {
        MapLab ml = new MapLab();
        ml.testStruct();
    }

    private void testStruct() {
//        HashMap<String,String> res =new HashMap<>(2);
//        for (int i = 0; i <20 ; i++) {
//            String UUIDs = UUID.randomUUID().toString();
//            res.put(UUIDs,UUIDs);
//        }

        ArrayList<String> arrayList =new ArrayList<>();
        arrayList.add("111");

        LinkedList<String> linkedList =new LinkedList<>();
        linkedList.add("111");

        Vector<String> vc =new Vector<>();
        vc.add("111");

    }

}
