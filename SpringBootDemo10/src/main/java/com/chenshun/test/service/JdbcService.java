package com.chenshun.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/3/28 13:37  <p />
 * Version: V1.0  <p />
 * Description:
 * CREATE TABLE user(id INT(11) PRIMARY KEY AUTO_INCREMENT,name VARCHAR(5));
 * <p/>
 */
@Service
public class JdbcService {

    @Autowired
    @Qualifier(value = "prodJdbcOperations")
    private JdbcOperations prodJdbcOperations;

    @Autowired
    @Qualifier(value = "devJdbcOperations")
    private JdbcOperations devJdbcOperations;

    @Transactional(value = "prodTransactionManager")
    public void prod() {
        List<Map<String, Object>> list = prodJdbcOperations.queryForList("SELECT * FROM user");
        list.forEach(stringObjectMap -> {
            stringObjectMap.forEach((s, o) -> System.out.print(s + "=" + o + " "));
            System.out.println();
        });
    }

    @Transactional(value = "devTransactionManager")
    public void dev() {
        List<Map<String, Object>> list = devJdbcOperations.queryForList("SELECT * FROM user");
        list.forEach(stringObjectMap -> {
            stringObjectMap.forEach((s, o) -> System.out.print(s + "=" + o + " "));
            System.out.println();
        });
    }

}
