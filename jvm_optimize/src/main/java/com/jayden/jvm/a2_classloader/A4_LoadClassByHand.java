package com.jayden.jvm.a2_classloader;

/**
 * 利用类加载器来加载系统资源
 */
public class A4_LoadClassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = A4_LoadClassByHand.class.getClassLoader()
                        .loadClass("com.jayden.jvm.a2_classloader.A1_ClassLoaderLevel");
        System.out.println(clazz.getName());
    }
}
