package com.jayden.jvm.a4_runtimeDataArea_InstructionSet;

/**
 * i 的值为什么是8
 */
public class A1_WhatsIAnswer {
    public static void main(String[] args) {
        int i = 8;
        i = i++;
//        i = ++i;
        System.out.println(i);
    }
}
