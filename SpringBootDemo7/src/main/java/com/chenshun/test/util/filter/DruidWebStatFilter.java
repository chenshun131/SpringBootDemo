package com.chenshun.test.util.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * User: mew <p />
 * Time: 18/3/13 11:12  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@WebFilter(
        filterName = "druidWebStatFilter",
        urlPatterns = "/*",
        initParams = {@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")}
)
public class DruidWebStatFilter extends WebStatFilter {

}
