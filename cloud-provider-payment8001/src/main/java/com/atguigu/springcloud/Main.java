package com.atguigu.springcloud;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        Object put = map.put("key", "value");
        System.out.println(put);
    }
}
