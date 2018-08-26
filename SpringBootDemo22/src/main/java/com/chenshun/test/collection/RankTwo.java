package com.chenshun.test.collection;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/7/30 22:06  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Order(2)
@Component
public class RankTwo implements Ranks {

    private String rank = "RankTwo";

    @Override
    public String toString() {
        return this.rank;
    }

}
