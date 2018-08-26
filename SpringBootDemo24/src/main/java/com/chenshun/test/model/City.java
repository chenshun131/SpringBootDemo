package com.chenshun.test.model;

import lombok.Data;

/**
 * User: chenshun131 <p />
 * Time: 18/8/2 15:59  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
public class City {

    /** 城市编号 */
    private Long id;

    /** 省份编号 */
    private Long provinceId;

    /** 城市名称 */
    private String cityName;

    /** 描述 */
    private String description;

}
