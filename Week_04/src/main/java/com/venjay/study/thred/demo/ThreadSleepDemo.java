package com.venjay.study.thred.demo;

/**
 * @author :liuwenjie
 * @description : 考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？
 * @date : 2020/11/10 13:15
 * @since 4.7.0
 **/
public class ThreadSleepDemo {
    /**
     * 第一种  sleep
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final int[] i = {0};
        new Thread("subthread" + i[0]) {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    i[0] = 10;
                    System.out.println(Thread.currentThread().getName() + "finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Thread.sleep(2000);
        System.out.println("main thread finished i="+i[0]);
    }


}
