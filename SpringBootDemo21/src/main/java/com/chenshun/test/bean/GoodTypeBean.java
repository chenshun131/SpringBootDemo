package com.chenshun.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodTypeBean {

    private Long id;

    private String name;

    private int show;

    private int order;

}
