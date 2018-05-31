package com.chenshun.springannotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * User: chenshun131 <p />
 * Time: 18/5/31 21:02  <p />
 * Version: V1.0  <p />
 * Description: Mac 系统 <p />
 */
public class MacCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        return property.contains("Mac");
    }

}
