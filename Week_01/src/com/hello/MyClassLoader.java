package com.hello;

import java.io.*;
import java.lang.reflect.Method;

/**
 * week01 题目2 必做
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。
 *
 * @author liuwenjie3306@163.com
 * @date 2020-10-21 18:01:02
 * @since 1.0.0
 */
public class MyClassLoader extends ClassLoader {
    private static final String BAST_PAHT = "/Users/liuwenjie/study/code/JAVA-000/Week_01/src/com/hello/";
    private static final int BUFF_SIZE = 1024;

    /**
     * 测试 MyClassLoader.findClass
     *
     * @param args args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        final Class<?> aClass = new MyClassLoader().findClass("Hello");
        final Object object = aClass.newInstance();
        Method method = object.getClass().getMethod("hello");
        method.invoke(object);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return this.loadClassData(name);
    }

    /**
     * 加载文件
     *
     * @param className 文件名称
     * @return Class
     */
    private Class loadClassData(String className) {
        final String filePath = BAST_PAHT + className + ".xlass";
        byte[] cLassBytes = new byte[BUFF_SIZE];
        final File file = new File(filePath);
        final ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
        BufferedInputStream bin = null;
        try {
            bin = new BufferedInputStream(new FileInputStream(file));
            int len = 0;
            while (-1 != (len = bin.read())) {
                len = 255 - len;
                bos.write(len);
            }
            cLassBytes = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                bin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return defineClass(className, cLassBytes, 0, cLassBytes.length);
    }

}
