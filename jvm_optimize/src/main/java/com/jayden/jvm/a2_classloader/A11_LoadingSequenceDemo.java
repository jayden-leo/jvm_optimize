package com.jayden.jvm.a2_classloader;

/**
 * 交换15行和16行, 观察count的结果,
 *
 * 分析除JVM执行顺序
 */
public class A11_LoadingSequenceDemo {
    public static void main(String[] args) {
        System.out.println(T.count);
    }
}

class T{
    public static T t = new T();
    public static int count = 2;

    private T(){
        count++;
    }
}
