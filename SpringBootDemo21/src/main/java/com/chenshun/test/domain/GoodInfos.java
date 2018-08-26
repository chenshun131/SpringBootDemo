package com.chenshun.test.domain;

import java.math.BigDecimal;

public class GoodInfos {
    private Integer tgId;

    private Integer tgTypeId;

    private String tgTitle;

    private BigDecimal tgPrice;

    private Integer tgOrder;

    public Integer getTgId() {
        return tgId;
    }

    public void setTgId(Integer tgId) {
        this.tgId = tgId;
    }

    public Integer getTgTypeId() {
        return tgTypeId;
    }

    public void setTgTypeId(Integer tgTypeId) {
        this.tgTypeId = tgTypeId;
    }

    public String getTgTitle() {
        return tgTitle;
    }

    public void setTgTitle(String tgTitle) {
        this.tgTitle = tgTitle == null ? null : tgTitle.trim();
    }

    public BigDecimal getTgPrice() {
        return tgPrice;
    }

    public void setTgPrice(BigDecimal tgPrice) {
        this.tgPrice = tgPrice;
    }

    public Integer getTgOrder() {
        return tgOrder;
    }

    public void setTgOrder(Integer tgOrder) {
        this.tgOrder = tgOrder;
    }
}