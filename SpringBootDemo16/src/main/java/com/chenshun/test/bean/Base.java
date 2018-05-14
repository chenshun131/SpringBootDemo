package com.chenshun.test.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User: mew <p />
 * Time: 18/5/9 13:53  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@ToString
public class Base {

    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String name;

}
