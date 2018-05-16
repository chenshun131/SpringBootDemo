package com.chenshun.test;

import com.chenshun.test.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void test1() throws InterruptedException {
        asyncService.asyncMethodWithVoidReturnType();
        System.out.println("完成执行");
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void test2() throws InterruptedException {
        asyncService.asyncInvokeWithParameter("chenshun");
        System.out.println("完成执行");
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void test3() throws InterruptedException, ExecutionException {
        // 多线程Future
        Future<String> future = asyncService.asyncInvokeReturnFuture(10);
        System.out.println("Future延迟3秒：" + future.get());
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void test4() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            asyncService.printThread();
        }
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void test5() {
    }

}
