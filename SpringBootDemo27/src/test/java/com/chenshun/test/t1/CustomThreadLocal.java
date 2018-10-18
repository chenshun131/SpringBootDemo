package com.chenshun.test.t1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: chenshun131 <p />
 * Time: 18/9/27 22:42  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class CustomThreadLocal {

    static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int j = i;
            pool.execute(new Thread(() -> {
                CustomThreadLocal.threadLocal.set("猿天地" + j);
                new Service().call();
            }));
        }
    }
}

class Service {

    public void call() {
        CustomThreadLocal.pool.execute(() -> new Dao().call());

    }
}

class Dao {

    public void call() {
        System.out.println(Thread.currentThread().getName() + "Dao:" + CustomThreadLocal.threadLocal.get());
    }
}
