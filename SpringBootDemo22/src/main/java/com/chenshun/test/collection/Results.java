package com.chenshun.test.collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: chenshun131 <p />
 * Time: 18/7/30 22:07  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Component
public class Results {

    @Autowired
    private List<Ranks> ranks;

    @Override
    public String toString() {
        return ranks.toString();
    }

}
