package com.chenshun.test.bean;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * User: mew <p />
 * Time: 18/5/9 14:11  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RequiredArgsConstructor
public class User3 {

    @NonNull
    private Integer id;

    @NonNull
    private String name = "bbbb";

    private final String phone;

}
