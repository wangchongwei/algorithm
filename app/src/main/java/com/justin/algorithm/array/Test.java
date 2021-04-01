package com.justin.algorithm.array;
/*
 * created by Justin on 2020/12/15
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

class Test {
    public static void main(String[] args) {
        Thread a = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("这是a线程在执行");
                try {
                    Thread.sleep(100);
                    System.out.println("这是a线程在休眠结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread b = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("这是b线程在执行");
            }
        };
        a.start();
        b.start();
    }
}
