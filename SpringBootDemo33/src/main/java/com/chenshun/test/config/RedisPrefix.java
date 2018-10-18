package com.chenshun.test.config;

import org.springframework.data.redis.cache.RedisCachePrefix;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * User: chenshun131 <p />
 * Time: 18/10/13 11:40  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class RedisPrefix implements RedisCachePrefix {

    private final RedisSerializer<String> serializer;

    private final String delimiter;

    public RedisPrefix() {
        this(":");
    }

    public RedisPrefix(String delimiter) {
        this.serializer = new StringRedisSerializer();
        this.delimiter = delimiter;
    }

    @Override
    public byte[] prefix(String cacheName) {
        return this.serializer.serialize(this.delimiter != null ? this.delimiter.concat(":").concat(cacheName).concat(":") : cacheName.concat(":"));
    }

}
