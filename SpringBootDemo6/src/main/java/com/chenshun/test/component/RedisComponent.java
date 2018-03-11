package com.chenshun.test.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * User: mew <p />
 * Time: 18/3/10 16:18  <p />
 * Version: V1.0  <p />
 * Description: Redis 组件 <p />
 */
@Component
public class RedisComponent {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public void set(String key, String value) {
		ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		if (!this.stringRedisTemplate.hasKey(key)) {
			ops.set(key, value);
			System.out.println("set key success");
		} else {
			// 存在则打印之前的value值
			System.out.println("this key = " + ops.get(key));
		}
	}

	public String get(String key) {
		return this.stringRedisTemplate.opsForValue().get(key);
	}

	public void del(String key) {
		this.stringRedisTemplate.delete(key);
	}

}
