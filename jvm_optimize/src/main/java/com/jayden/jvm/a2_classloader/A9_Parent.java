package com.jayden.jvm.a2_classloader;

/**
 * 解释类加载器之间的关系
 *
 * 并不是继承关系,而是一个引用
 */
public class A9_Parent {
    private static A5_CustomClassLoader parent = new A5_CustomClassLoader();

    private static class MyLoader extends ClassLoader{
        public MyLoader(){
            super(parent);
        }
    }
}
