package com.woniuxy.utils;

import org.junit.Test;

public class NoGenerator {
    //    public static void main(String[] args) {
//        String s = NoGenerator.generatorNo();
//        System.out.println(s);
//    }
    public static String generatorNo() {
        String s = "";
        for (int i = 0; i < 18; i++) {
            s += (int) (Math.random() * 10);
        }
        return s;
    }
}
