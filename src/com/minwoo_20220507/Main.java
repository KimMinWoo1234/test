package com.minwoo_20220507;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        System.out.println(map.get("A"));
        System.out.println(map.get("B"));
        System.out.println(map.containsKey("A"));
        System.out.println(map.containsValue("aa"));

    }
}
