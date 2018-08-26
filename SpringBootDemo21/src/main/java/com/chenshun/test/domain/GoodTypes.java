package com.chenshun.test.domain;

public class GoodTypes {
    private Integer tgtId;

    private String tgtName;

    private Integer tgtIsShow;

    private Integer tgtOrder;

    public Integer getTgtId() {
        return tgtId;
    }

    public void setTgtId(Integer tgtId) {
        this.tgtId = tgtId;
    }

    public String getTgtName() {
        return tgtName;
    }

    public void setTgtName(String tgtName) {
        this.tgtName = tgtName == null ? null : tgtName.trim();
    }

    public Integer getTgtIsShow() {
        return tgtIsShow;
    }

    public void setTgtIsShow(Integer tgtIsShow) {
        this.tgtIsShow = tgtIsShow;
    }

    public Integer getTgtOrder() {
        return tgtOrder;
    }

    public void setTgtOrder(Integer tgtOrder) {
        this.tgtOrder = tgtOrder;
    }
}