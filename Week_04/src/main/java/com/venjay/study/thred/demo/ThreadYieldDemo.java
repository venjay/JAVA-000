package com.venjay.study.thred.demo;

/**
 * @author :liuwenjie
 * @description : 考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？
 * @date : 2020/11/10 13:15
 * @since 4.7.0
 **/
public class ThreadYieldDemo {
    /**
     * 第四种  yield
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 关键参数
        final int[] i = {0};
        int defaultThreadNum = 2;
        new Thread("subthread" + i) {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        while (Thread.activeCount() > defaultThreadNum) {
            // 当活跃线程数大于设定的默认线程数的时候 主线程让步
            Thread.yield();
        }
        System.out.println("main thread finished i=" + i[0]);
    }


}
