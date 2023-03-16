package com.jayden.jvm.a2_classloader;

/**
 * 展示每个类加载器加载的文件夹路径
 */
public class A2_ClassLoaderScope {
    public static void main(String[] args) {
        System.out.println("BootStrapClassLoader加载的路径");
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println(pathBoot.replaceAll(";", System.lineSeparator()));

        System.out.println("--------------------");
        System.out.println("ExtensionClassLoader加载的路径");
        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println(pathExt.replaceAll(";", System.lineSeparator()));

        System.out.println("--------------------");
        System.out.println("ApplicationClassLoader加载的路径");
        String pathApp = System.getProperty("java.class.path");
        System.out.println(pathApp.replaceAll(";", System.lineSeparator()));
    }
}
