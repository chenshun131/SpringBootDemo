package com.chenshun.configserverrabbit.bean;

import lombok.Data;

/**
 * User: chenshun131 <p />
 * Time: 18/5/23 22:44  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
public class Order {

    private Long id;

    private String name;

    private Integer count;

}
