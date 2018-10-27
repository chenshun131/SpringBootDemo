package com.chenshun.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodInfoBean {

    private Long id;

    private String title;

    private double price;

    private int order;

    private Long typeId;

}
