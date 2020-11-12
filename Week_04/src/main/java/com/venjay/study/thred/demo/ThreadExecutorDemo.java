package com.venjay.study.thred.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author :liuwenjie
 * @description : 考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？
 * @date : 2020/11/10 13:15
 * @since 4.7.0
 **/
public class ThreadExecutorDemo {
    /**
     * 第二种  Executors
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建一个ExecutorService
        ExecutorService ex = Executors.newCachedThreadPool();
        final int[] i = {0};
        // 添加 task
        ex.submit(new Thread("subthread" + i) {
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
        });
        //使用shutdown 会通知executorservice 停止添加其它task
        ex.shutdown();
        try {
            // 设置等待时间等待子线程运行完毕
            if (!ex.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                // 等待时间内子线程并未全部运行完毕就直接关闭
                ex.shutdownNow();
            }
        } catch (InterruptedException e) {
            ex.shutdownNow();
        }
        System.out.println("main thread finished i=" + i[0]);
    }


}
