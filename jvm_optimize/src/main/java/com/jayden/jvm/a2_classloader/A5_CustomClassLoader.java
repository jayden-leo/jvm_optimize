package com.jayden.jvm.a2_classloader;

import com.jayden.jvm.a2_classloader.fortest.Hello;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义ClassLoader
 * (1) 继承ClassLoader类
 * (2) 重写findClass方法
 * (3) 用流的形式加载某个类,然后用defineClass方法将类加载到jvm中
 * (3) 用自定义ClassLoader加载对象
 */
public class A5_CustomClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("D:\\A3_MAC\\jvm_optimize\\jvm_optimize\\target\\classes\\",name.replace(".","/").concat(".class"));
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b;

            while ((b=fis.read()) !=0) {
                baos.write(b);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();//可以写的更加严谨

            return defineClass(name, bytes, 0, bytes.length); // 把流在jvm中变成class对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name); //throws ClassNotFoundException
    }

    public static void main(String[] args) throws Exception{
        ClassLoader customClassLoader = new A5_CustomClassLoader();
        Class clazz1 = customClassLoader.loadClass("com.jayden.jvm.a2_classloader.fortest.Hello");
        Class clazz2 = customClassLoader.loadClass("com.jayden.jvm.a2_classloader.fortest.Hello");

        System.out.println(clazz1 == clazz2);

        Hello h = (Hello)clazz1.newInstance();
        h.m();

        System.out.println(customClassLoader.getClass().getClassLoader());
        System.out.println(customClassLoader.getParent());

        System.out.println(getSystemClassLoader());
    }
}
