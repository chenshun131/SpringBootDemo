package com.chenshun.test.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * User: mew <p />
 * Time: 18/5/9 14:22  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
@Accessors(fluent = true, chain = true, prefix = "abc")
public class User7 {

    private Integer id;

    private String name;

    private String abcAge;

}
