package com.chenshun.test.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * User: chenshun131 <p />
 * Time: 18/10/13 17:43  <p />
 * Version: V1.0  <p />
 * Description: guava缓存配置 <p />
 */
@Configuration
@EnableCaching
public class GuavaConfig {

    private static final int DEFAULT_MAXSIZE = 1000;

    private static final int DEFAULT_TTL = 3600;

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager manager = new SimpleCacheManager();
        // 把各个cache注册到cacheManager中，GuavaCache实现了org.springframework.cache.Cache接口
        ArrayList<GuavaCache> caches = new ArrayList<>();
        for (Caches c : Caches.values()) {
            caches.add(new GuavaCache(c.name(),
                    CacheBuilder.newBuilder().recordStats().expireAfterWrite(c.getTtl(), TimeUnit.SECONDS).maximumSize(c.getMaxSize()).build()));
        }
        manager.setCaches(caches);
        return manager;
    }

    /**
     * 定义cache名称、超时时长秒、最大个数
     * 每个cache缺省3600秒过期，最大个数1000
     */
    public enum Caches {
        user(60, 2),
        info(5),
        role;

        /** 最大數量 */
        private int maxSize = DEFAULT_MAXSIZE;

        /** 过期时间(秒) */
        private int ttl = DEFAULT_TTL;

        Caches() {
        }

        Caches(int ttl) {
            this.ttl = ttl;
        }

        Caches(int ttl, int maxSize) {
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(int maxSize) {
            this.maxSize = maxSize;
        }

        public int getTtl() {
            return ttl;
        }

        public void setTtl(int ttl) {
            this.ttl = ttl;
        }
    }

}