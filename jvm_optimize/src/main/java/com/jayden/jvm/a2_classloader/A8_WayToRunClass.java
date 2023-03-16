package com.jayden.jvm.a2_classloader;

/**
 * 展示, 混合编译模式情况下, 纯解释器和纯即时编译器运行程序 速度的差距优势
 *
 * -Xmixed  混合模式(m默认)   1937
 * -Xint    解释器模式        50784
 * -Xcomp   即时编译器模式     1954
 *
 * 分别用不同方式运行, 感受速度差距
 */
public class A8_WayToRunClass {
    public static void main(String[] args) {
        for(int i=0; i<10_0000; i++)
            m();

        long start = System.currentTimeMillis();
        for(int i=0; i<10_0000; i++) {
            m();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void m() {
        for(long i=0; i<10_0000L; i++) {
            long j = i%3;
        }
    }
}
