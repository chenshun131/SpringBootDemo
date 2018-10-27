package com.chenshun.test.mapper;

import com.chenshun.test.bean.GoodInfoBean;
import com.chenshun.test.bean.GoodTypeBean;
import com.chenshun.test.dto.GoodInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 配置映射
 */
@Mapper(componentModel = "spring")
public interface GoodInfoMapper {

    GoodInfoMapper MAPPER = Mappers.getMapper(GoodInfoMapper.class);

    @Mappings({
            @Mapping(source = "type.name", target = "typeName"),
            @Mapping(source = "good.id", target = "goodId"),
            @Mapping(source = "good.title", target = "goodName"),
            @Mapping(source = "good.price", target = "goodPrice")
    })
    GoodInfoDTO from(GoodInfoBean good, GoodTypeBean type);

}
