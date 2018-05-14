package com.chenshun.test.bean;

import lombok.Data;
import lombok.NonNull;

/**
 * User: mew <p />
 * Time: 18/5/9 14:17  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
public class User6 {

    @NonNull
    private Integer id;

    @NonNull
    private String name = "bbbb";

    private final String phone;

}
