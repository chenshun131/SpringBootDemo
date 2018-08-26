package com.chenshun.test.mapper;

import com.chenshun.test.domain.BasicObjectMapper;
import com.chenshun.test.domain.CategoryVo;
import com.chenshun.test.domain.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * User: chenshun131 <p />
 * Time: 18/7/29 19:03  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Mapper
public interface CategoryMapper extends BasicObjectMapper<CategoryVo, ProductCategory> {

    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);

    @Mappings({
            @Mapping(source = "code", target = "categoryCode"),
            @Mapping(source = "name", target = "categoryName")
    })
    ProductCategory to(CategoryVo source);

}
