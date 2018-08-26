package com.chenshun.test.dto;

import lombok.Data;

/**
 * User: chenshun131 <p />
 * Time: 18/7/25 22:17  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
public class GoodInfoDTO {

    /** 商品编号 */
    private String goodId;

    /** 商品名称 */
    private String goodName;

    /** 商品价格 */
    private double goodPrice;

    /** 类型名称 */
    private String typeName;

}
