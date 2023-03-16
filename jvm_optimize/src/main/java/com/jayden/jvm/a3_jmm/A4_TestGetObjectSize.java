package com.jayden.jvm.a3_jmm;

import agent.ObjectSizeAgent;

/**
 * 使用下面参数运行本类,查看对象在JVM中具体存储
 * -javaagent:D:\A3_MAC\jvm_optimize\help\ObjectSize\out\artifacts\ObjectSize_jar\ObjectSize.jar
 * -XX:-UseCompressedClassPointers  (默认8个字节, 压缩后4个字节 可以+ 可以-  模式是+)
 * -XX:+UseCompressedOops  (Oops: Ordinary Object Pointers 原理同上)
 */
public class A4_TestGetObjectSize {
    public static void main(String[] args) {
        // 16个字节 8(markword)+4(classPointer)+4(padding)
        System.out.println(ObjectSizeAgent.sizeOf(new Object()));

        // 16个字节 8(markword)+4(classPointer)+4(数组长度)
        System.out.println(ObjectSizeAgent.sizeOf(new int[] {}));


        System.out.println(ObjectSizeAgent.sizeOf(new P()));
    }

    private static class P {
        //8 _markword
        //4 _oop指针
        int id;         //4
        String name;    //4
        int age;        //4

        byte b1;        //1
        byte b2;        //1

        Object o;       //4
        byte b3;        //1

    }
}
