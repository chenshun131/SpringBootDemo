package com.chenshun.test.domain;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * User: chenshun131 <p />
 * Time: 18/7/29 19:01  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface BasicObjectMapper<SOURCE, TARGET> {

    @Mappings({})
    @InheritConfiguration
    TARGET to(SOURCE var1);

    @InheritConfiguration
    List<TARGET> to(List<SOURCE> var1);

    @InheritInverseConfiguration
    SOURCE from(TARGET var1);

    @InheritInverseConfiguration
    List<SOURCE> from(List<TARGET> var1);

}
