package com.hello;

/**
 * @author liuwenjie3306@163.com
 * @date 2020-10-21 18:01:02
 * @since 1.0.0
 */
public class Hello01 {
    /**
     * 1.（选做）自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，。<br/>
     * 然后自己分析一下对应的字节码，有问题群里讨论
     * <p>
     * ------
     * ------
     */
    public void hello() {
        int a = 10;
        int b = 5;
        Long c = 20L;
        Long d = 10L;
        byte e = 2;
        byte f = 7;
        int sum = a + b;
        int difference = a - b;
        Long multiply = a * d;
        int divide = a / b;
        if (divide > 0) {
            sum = e + f;
        }
        for (int i = 0; i < e; i++) {
            c += i;
        }
    }

}