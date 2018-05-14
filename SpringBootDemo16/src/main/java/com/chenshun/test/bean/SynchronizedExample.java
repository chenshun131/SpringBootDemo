package com.chenshun.test.bean;

import lombok.Synchronized;

/**
 * User: mew <p />
 * Time: 18/5/9 14:26  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class SynchronizedExample {

    private final Object readLock = new Object();

    @Synchronized
    public static void hello() {
        System.out.println("world");
    }

    @Synchronized
    public int answerToLife() {
        return 42;
    }

    @Synchronized("readLock")
    public void foo() {
        System.out.println("bar");
    }

}
