package com.chenshun.test.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodInfos {

    private Integer tgId;

    private Integer tgTypeId;

    private String tgTitle;

    private BigDecimal tgPrice;

    private Integer tgOrder;

}
