package com.chenshun.test.bean;

import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * User: mew <p />
 * Time: 18/5/9 14:08  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@NoArgsConstructor(force = true)
public class User2 {

    @NonNull
    private Integer id;

    @NonNull
    private String name;

    private final String phone;

}
