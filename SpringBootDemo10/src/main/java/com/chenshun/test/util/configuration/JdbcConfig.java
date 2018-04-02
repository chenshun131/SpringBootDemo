package com.chenshun.test.util.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * User: mew <p />
 * Time: 18/3/28 12:39  <p />
 * Version: V1.0  <p />
 * Description: 多数据源 <p />
 */
@Configuration
public class JdbcConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.prod")
    public DataSourceProperties prodDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource prodDataSource() {
        return prodDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.dev")
    public DataSourceProperties devDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource devDataSource() {
        return devDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public JdbcOperations prodJdbcOperations(@Qualifier("prodDataSource") DataSource prodDataSource) {
        return new JdbcTemplate(prodDataSource);
    }

    @Bean
    public JdbcOperations devJdbcOperations(@Qualifier("devDataSource") DataSource devDataSource) {
        return new JdbcTemplate(devDataSource);
    }

    @Bean
    public PlatformTransactionManager prodTransactionManager(@Qualifier("prodDataSource") DataSource prodDataSource) {
        return new DataSourceTransactionManager(prodDataSource);
    }

    @Bean
    public PlatformTransactionManager devTransactionManager(@Qualifier("devDataSource") DataSource sitDataSource) {
        return new DataSourceTransactionManager(sitDataSource);
    }

}
