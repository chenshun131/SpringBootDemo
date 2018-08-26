package com.chenshun.test;

import com.chenshun.test.domain.CategoryVo;
import com.chenshun.test.domain.ProductCategory;
import com.chenshun.test.mapper.CategoryMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * User: chenshun131 <p />
 * Time: 18/7/25 22:56  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    public static void main(String[] args) {
        CategoryMapper categoryMapper = CategoryMapper.MAPPER;

        CategoryVo vo = new CategoryVo();
        vo.setCode("0000");
        vo.setName("属性名称");

        ProductCategory pc = categoryMapper.to(vo); // 通过 to方法得到 ProductCategory
        System.out.println("1" + pc);

        CategoryVo vo1 = categoryMapper.from(pc); // 通过 from方法得到 CategoryVo，既反转 to方法。
        System.out.println("2" + vo1);

        List<ProductCategory> pcList = categoryMapper.to(Arrays.asList(vo, vo1));// 通过to方法从集合得到转换后的集合
        System.out.println("3" + pcList);

        List<CategoryVo> voList = categoryMapper.from(pcList); // 反转集合
        System.out.println("4" + voList);
    }

}
