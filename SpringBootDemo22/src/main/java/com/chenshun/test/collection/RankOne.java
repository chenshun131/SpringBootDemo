package com.chenshun.test.collection;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/7/30 22:05  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Order(1)
@Component
public class RankOne implements Ranks {

    private String rank = "RankOne";

    @Override
    public String toString() {
        return this.rank;
    }

}
