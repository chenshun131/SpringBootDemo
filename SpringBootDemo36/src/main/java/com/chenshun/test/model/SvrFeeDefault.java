package com.chenshun.test.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SvrFeeDefault implements Serializable {

    private static final long serialVersionUID = 290369309743986398L;

    private Integer svrid;

    private BigDecimal cardrate;

    private BigDecimal payamountrate;

    private BigDecimal minfee;

    private BigDecimal maxfee;

    private BigDecimal yearmaxfee;

    private BigDecimal headerrate;

    private BigDecimal agentrate;

    private Integer payway;

    private Integer cardtype;

    private Date modifytime;

    private String modifyuser;

    private String createuser;

    private Date createtime;

}
