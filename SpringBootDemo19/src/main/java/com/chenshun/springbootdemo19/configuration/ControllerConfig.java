package com.chenshun.springbootdemo19.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * User: mew <p />
 * Time: 18/5/31 13:53  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@ControllerAdvice
public class ControllerConfig {

    @Autowired
    ResourceUrlProvider resourceUrlProvider;

    @ModelAttribute("urls")
    public ResourceUrlProvider urls() {
        return this.resourceUrlProvider;
    }

}
