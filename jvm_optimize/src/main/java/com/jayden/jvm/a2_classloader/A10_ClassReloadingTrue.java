package com.jayden.jvm.a2_classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 热部署  成功
 */
public class A10_ClassReloadingTrue {
    private static class MyClassLoader extends ClassLoader{
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            File f = new File("D:\\A3_MAC\\jvm_optimize\\jvm_optimize\\target\\classes\\"
                    +name.replace(".","/").concat(".class"));
            if (!f.exists()) return super.loadClass(name);

            try {
                InputStream is = new FileInputStream(f);

                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return super.loadClass(name);
        }
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader();
        Class clazz = classLoader.loadClass("com.jayden.jvm.a2_classloader.fortest.Hello");

        //  热部署是这样部署的:
        classLoader = new MyClassLoader();
        Class clazzNew = classLoader.loadClass("com.jayden.jvm.a2_classloader.fortest.Hello");

        System.out.println(clazz == clazzNew);
    }
}
