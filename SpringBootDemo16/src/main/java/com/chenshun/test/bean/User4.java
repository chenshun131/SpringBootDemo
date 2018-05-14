package com.chenshun.test.bean;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * User: mew <p />
 * Time: 18/5/9 14:12  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RequiredArgsConstructor(staticName = "of")
public class User4 {

    @NonNull
    private Integer id;

    @NonNull
    private String name = "bbbb";

    private final String phone;
}
