package com.chenshun.test.util.configuration;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * User: mew <p />
 * Time: 18/3/11 22:1t  <p />
 * Version: V1.0  <p />
 * Description: redis 自定义key值生成器 <p />
 */
@Configuration
public class RedisCacheConfiguration extends CachingConfigurerSupport {

    /**
     * 自定义key，此方法将会根据 类名+方法名+所有参数的值 生成唯一的一个key,即使 @Cacheable 中的 value 属性一样，key 也会不一样
     */
    @Override
    public KeyGenerator keyGenerator() {
        return (o, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName());
            sb.append(method.getName());
            for (Object obj : objects) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }

}
