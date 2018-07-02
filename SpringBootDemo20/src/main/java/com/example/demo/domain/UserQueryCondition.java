package com.example.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * User: chenshun131 <p />
 * Time: 18/6/24 10:10  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
public class UserQueryCondition {

    private String username;

    @ApiModelProperty(value = "用户年龄起始值")
    private int age;

    @ApiModelProperty(value = "用户年龄终止值")
    private int ageTo;

    private String xxx;

}
