package com.thread;

/**
 * 线程执行方法
 */
public class MyThreadMethod extends Thread  {
    public void run() {
        while (!this.isInterrupted()) {// 线程未中断执行循环
            try {
                Thread.sleep(5000); //每隔2000ms执行一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
