package com.chenshun.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * User: chenshun131 <p />
 * Time: 18/10/18 23:19  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store implements Serializable {

    private String str1;

    private String str2;

    private BigDecimal bd1;

    private BigDecimal bd2;

    private Integer int1;

    private Integer int2;

    private Date date1;

    private Date date2;

}
