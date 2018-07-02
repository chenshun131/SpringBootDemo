package com.chenshun.core.properties;

import lombok.Data;
import sun.security.util.SecurityConstants;

/**
 * User: chenshun131 <p />
 * Time: 18/6/24 14:37  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
public class BrowserProperties {

    /** session管理配置项 */
    private SessionProperties session = new SessionProperties();

    /** '记住我'功能的有效时间，默认1小时 */
    private int rememberMeSeconds = 3600;

    /** 模块自定义的 跳转页面 */
    private String signUpUrl = "/pc-signUp.html";

    /** 登录响应的方式，默认是json */
    private LoginResponseType signInResponseType = LoginResponseType.JSON;

    /** 登录成功后跳转的地址，如果设置了此属性，则登录成功后总是会跳到这个地址上。只在signInResponseType为REDIRECT时生效 */
    private String singInSuccessUrl;

}
