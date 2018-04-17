package com.chenshun.test.util.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * User: chenshun131 <p />
 * Time: 18/4/16 21:46  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Configuration
public class JdbcConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.prod")
    public DataSource prodDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.dev")
    public DataSource devDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcOperations prodJdbcOperations(@Qualifier("prodDataSource") DataSource prodDataSource) {
        return new JdbcTemplate(prodDataSource);
    }

    @Bean
    public JdbcOperations devJdbcOperations(@Qualifier("devDataSource") DataSource devDataSource) {
        return new JdbcTemplate(devDataSource);
    }

    // 创建事务管理器
    @Bean
    public PlatformTransactionManager prodTransactionManager(@Qualifier("prodDataSource") DataSource prodDataSource) {
        return new DataSourceTransactionManager(prodDataSource);
    }

    @Bean
    public PlatformTransactionManager devTransactionManager(@Qualifier("devDataSource") DataSource sitDataSource) {
        return new DataSourceTransactionManager(sitDataSource);
    }

}
