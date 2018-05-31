package com.chenshun.common.anno;

import java.lang.annotation.*;

/**
 * User: mew <p />
 * Time: 18/5/31 16:53  <p />
 * Version: V1.0  <p />
 * Description: 对 API 进行访问速度限制，限制的速度值在 Smconf配置 中通过 key关联<p />
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiRateLimit {

    /**
     * Smconf 配置中的key
     *
     * @return
     */
    String confKey();

}
