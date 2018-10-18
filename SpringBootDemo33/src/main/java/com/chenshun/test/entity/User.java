package com.chenshun.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: chenshun131 <p />
 * Time: 18/10/13 14:06  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private String password;

}
