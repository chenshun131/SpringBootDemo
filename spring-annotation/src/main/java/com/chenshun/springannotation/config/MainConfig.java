package com.chenshun.springannotation.config;

import com.chenshun.springannotation.bean.Person;
import com.chenshun.springannotation.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

@Configuration // @Configuration : 指定这是一个 Spring配置类
@ComponentScans(
        value = {
                @ComponentScan(value = "com.chenshun", includeFilters = {
                        @Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                        @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                        @Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
                }, useDefaultFilters = false)
        }
)
// @ComponentScan value : 指定要扫描的包
// excludeFilters = Filter[] : 指定扫描的时候按照什么规则排除那些组件
// includeFilters = Filter[] : 指定扫描的时候只需要包含哪些组件
// FilterType.ANNOTATION : 按照注解
// FilterType.ASSIGNABLE_TYPE : 按照给定的类型
// FilterType.ASPECTJ : 使用 ASPECTJ表达式
// FilterType.REGEX : 使用正则指定
// FilterType.CUSTOM : 使用自定义规则
public class MainConfig {

    // @Bean : 给容器中注册一个 Bean，类型为返回值的类型，id 默认是用方法名作为id，也可以通过 value 属性指定
    @Bean("person")
    public Person person01() {
        return new Person("lisi", 20);
    }

}
