package com.chenshun.test;

/**
 * User: chenshun131 <p />
 * Time: 18/9/27 22:18  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class CustomThreadLocal {

    static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            CustomThreadLocal.threadLocal.set("猿天地");
            new Service().call();
        }).start();
    }
}

class Service {

    public void call() {
        System.out.println("Service:" + Thread.currentThread().getName());
        System.out.println("Service:" + CustomThreadLocal.threadLocal.get());
        new Thread(() -> new Dao().call()).start();
    }
}

class Dao {

    public void call() {
        System.out.println("==========================");
        System.out.println("Dao:" + Thread.currentThread().getName());
        System.out.println("Dao:" + CustomThreadLocal.threadLocal.get());
    }
}
