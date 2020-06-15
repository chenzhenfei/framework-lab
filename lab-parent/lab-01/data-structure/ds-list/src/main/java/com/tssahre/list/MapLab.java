package com.tssahre.list;

import java.util.HashMap;
import java.util.UUID;

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
        HashMap<String,String> res =new HashMap<>(2);
        for (int i = 0; i <20 ; i++) {
            String UUIDs = UUID.randomUUID().toString();
            res.put(UUIDs,UUIDs);
        }
    }

}
