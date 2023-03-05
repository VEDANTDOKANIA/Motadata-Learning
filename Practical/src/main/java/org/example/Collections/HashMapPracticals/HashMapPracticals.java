package org.example.Collections.HashMapPracticals;

import java.util.HashMap;
import java.util.Map;

public class HashMapPracticals {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("Key1","Value1");
        map.put("Key2", "Value2");

        map.computeIfAbsent("Key3", key->"Nikunj");
        map.values();

        System.out.println(map);
    }
}
