package com.jayden.jvm.a2_classloader;

/**
 * 各种类是哪个类加载器加载的?
 * 有四种类加载器, 最顶层是由C++实现的BootStrapClassLoader,
 *          然后依次到 ExtensionClassLoader AppClassLoader 和自定义的CustomClassLoader
 */
public class A1_ClassLoaderLevel {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader()); //BootStrapClassLoader
        System.out.println(sun.awt.HKSCS.class.getClassLoader()); //BootStrapClassLoader
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader()); //ExtensionClassLoader
        System.out.println(A1_ClassLoaderLevel.class.getClassLoader()); // AppClassLoader

        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader()
                            .getClass().getClassLoader()); //BootStrapClassLoader
        System.out.println(A1_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader()); //BootStrapClassLoader


        System.out.println(ClassLoader.getSystemClassLoader()); // AppClassLoader
    }
}
