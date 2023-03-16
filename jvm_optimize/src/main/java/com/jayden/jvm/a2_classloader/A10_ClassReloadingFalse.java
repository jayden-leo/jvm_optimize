package com.jayden.jvm.a2_classloader;

/**
 *  热部署实例:
 *
 *  以下无法做到热部署, 因为A5_CustomClassLoader它只是重写了findClass方法, 如果需要完全刷新需要重写loadClass方法
 */
public class A10_ClassReloadingFalse {
    public static void main(String[] args) throws Exception {
        A5_CustomClassLoader customClassLoader = new A5_CustomClassLoader();
        Class clazz1 = customClassLoader.loadClass("com.jayden.jvm.a2_classloader.fortest.Hello");
        System.out.println(clazz1.hashCode());
        customClassLoader = null;

        customClassLoader = new A5_CustomClassLoader();
        Class clazz2 = customClassLoader.loadClass("com.jayden.jvm.a2_classloader.fortest.Hello");
        System.out.println(clazz2.hashCode());

        System.out.println(clazz1==clazz2);

    }
}
