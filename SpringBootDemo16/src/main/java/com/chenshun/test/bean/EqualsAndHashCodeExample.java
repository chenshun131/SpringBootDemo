package com.chenshun.test.bean;

import lombok.EqualsAndHashCode;

/**
 * User: mew <p />
 * Time: 18/5/9 14:02  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@EqualsAndHashCode(exclude = {"id"}, callSuper = false)
public class EqualsAndHashCodeExample {

    private transient int transientVar = 10;

    private int id;

    private String name;

    private double score;

    private String[] tags;

}
