package com.chenshun.test.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * User: mew <p />
 * Time: 18/5/15 11:36  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Service
public class AsyncService {

    /**
     * 不带参数的异步调用
     *
     * @return
     */
    @Async
    public String asyncMethodWithVoidReturnType() {
        System.out.println("线程名称：" + Thread.currentThread().getName() + " be ready to read data!");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "--> 无返回值延迟5秒：");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "已进入到异步";
    }

    /**
     * 带参数的异步调用 异步方法可以传入参数
     *
     * @param s
     */
    @Async
    public void asyncInvokeWithParameter(String s) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("asyncInvokeWithParameter, parementer=" + s);
    }

    /**
     * 调用返回Future 的异步线程
     *
     * @param i
     * @return
     */
    @Async
    public Future<String> asyncInvokeReturnFuture(int i) {
        System.out.println("asyncInvokeReturnFuture, parementer=" + i);
        Future<String> future;
        try {
            Thread.sleep(3000);
            future = new AsyncResult<>("success:" + i);
        } catch (InterruptedException e) {
            future = new AsyncResult<>("error");
        }
        return future;
    }

    @Async
    public void printThread() {
        System.out.println(Thread.currentThread().getName());
    }

}
