package com.jayden.jvm.a2_classloader;

/**
 * 展示类加载器的层级关系
 */
public class A3_ClassloaderParentAndChild {
    public static void main(String[] args) {
        System.out.println(A3_ClassloaderParentAndChild.class.getClassLoader()); // ApplicationClassLoader
        System.out.println(A3_ClassloaderParentAndChild.class.getClassLoader().getClass().getClassLoader()); // BootStrapClassLoader
        System.out.println(A3_ClassloaderParentAndChild.class.getClassLoader().getParent()); // ExtensionClassLoader
        System.out.println(A3_ClassloaderParentAndChild.class.getClassLoader().getParent().getParent()); // BootStrapClassLoader
        //System.out.println(T004_ParentAndChild.class.getClassLoader().getParent().getParent().getParent()); //Null
    }
}
