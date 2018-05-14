package com.chenshun.test.bean;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * User: mew <p />
 * Time: 18/5/9 14:15  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@AllArgsConstructor
public class User5 {

    @NonNull
    private Integer id;

    @NonNull
    private String name = "bbbb";

    private final String phone;

}
