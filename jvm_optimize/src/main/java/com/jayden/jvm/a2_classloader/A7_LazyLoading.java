package com.jayden.jvm.a2_classloader;

/**
 * 懒加载实例
 *
 * 严格讲应该叫lazy initialzing，因为java虚拟机规范并没有严格规定什么时候必须loading,但严格规定了什么时候initialzing
 */
public class A7_LazyLoading {
    public static void main(String[] args) throws Exception {
//        P p; // 啥也不加载
//        X x = new X();  // 两个都加载
//        System.out.println(P.i); // 8  final修饰的在还没有初始化的时候就定好了, 此时还没有实例化对象
//        System.out.println(P.j); // P,9 初始化时候,加载静态代码块后按顺序加载静态属性
        Class.forName("com.jayden.jvm.a2_classloader.A7_LazyLoading$P"); // ?

    }

    public static class P {
        final static int i = 8;
        static int j = 9;
        static {
            System.out.println("P");
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}
