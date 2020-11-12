package com.venjay.study.thred.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :liuwenjie
 * @description : 考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？
 * @date : 2020/11/10 13:15
 * @since 4.7.0
 **/
public class ThreadJoinDemo {
    /**
     * 第三种  join
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        final int[] i = {0};
        Thread t = new Thread("subthread" + i) {
            @Override
            public void run() {
                try {
                    i[0] = 10;
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        list.add(t);
        t.start();
        for (Thread item : list) {
            item.join();
        }
        System.out.println("main thread finished i=" + i[0]);
    }


}
