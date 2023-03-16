package com.jayden.jvm.a3_jmm;

/**
 * 观察字节码文件
 */
public class A2_TestSynchronized {
    synchronized void m() {

    }

    void n() {
        synchronized (this) {

        }
    }

    public static void main(String[] args) {

    }
}
