package com.chenshun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    private void test1() {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);

        Mono mono = Mono.just(1);
    }

    private void test2() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        Flux<Integer> flux = Flux.fromArray(array);
    }

    private void test3() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        List<Integer> list = Arrays.asList(array);
        Stream<Integer> stream = list.stream();
        Flux<Integer> flux = Flux.fromStream(stream);
    }

    private void test4() {
        // 只有完成信号的空数据流
        Flux.just();
        Flux.empty();

        Mono.empty();
        Mono.justOrEmpty(Optional.empty());


        // 只有错误信号的数据流
        Flux.error(new Exception("some error"));
        Mono.error(new Exception("some error"));
    }

}
