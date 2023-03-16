package com.jayden.jvm.a2_classloader;

import com.jayden.jvm.a2_classloader.fortest.Hello;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 调优实例: 利用自定义类加载器实现class的加密并解密加载到JVM中
 */
public class A6_CustomClassLoaderForEncryption extends ClassLoader{
    public static int seed = 0B10110110;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("D:\\A3_MAC\\jvm_optimize\\jvm_optimize\\target\\classes\\", name.replace(".", "/").concat(".myclass"));

        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b=fis.read()) !=0) {
                baos.write(b ^ seed);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();//可以写的更加严谨

            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name); //throws ClassNotFoundException
    }

    public static void main(String[] args) throws Exception {

        encFile("com.jayden.jvm.a2_classloader.fortest.Hello");

        ClassLoader classLoader = new A6_CustomClassLoaderForEncryption();
        Class clazz = classLoader.loadClass("com.jayden.jvm.a2_classloader.fortest.Hello");
        Hello h = (Hello)clazz.newInstance();
        h.m();

        System.out.println(classLoader.getClass().getClassLoader());
        System.out.println(classLoader.getParent());
    }

    private static void encFile(String name) throws Exception {
        File f = new File("D:\\A3_MAC\\jvm_optimize\\jvm_optimize\\target\\classes\\", name.replace('.', '/').concat(".class"));
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(
                new File("D:\\A3_MAC\\jvm_optimize\\jvm_optimize\\target\\classes\\", name.replace(".", "/").concat(".myclass")));
        int b = 0;

        while((b = fis.read()) != -1) {
            fos.write(b ^ seed);
        }

        fis.close();
        fos.close();
    }
}
