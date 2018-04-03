package com.chenshun.test.util.configuration;

import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: mew <p />
 * Time: 18/4/3 08:52  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Configuration
public class ShardingJDBCConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.ds0")
    public DataSourceProperties ds1DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource ds1DataSource() {
        return ds1DataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.ds1")
    public DataSourceProperties ds2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource ds2DataSource() {
        return ds2DataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.ds2")
    public DataSourceProperties ds3DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource ds3DataSource() {
        return ds3DataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.ds3")
    public DataSourceProperties ds4DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource ds4DataSource() {
        return ds4DataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.ds4")
    public DataSourceProperties ds5DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource ds5DataSource() {
        return ds5DataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.ds5")
    public DataSourceProperties ds6DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource ds6DataSource() {
        return ds6DataSourceProperties().initializeDataSourceBuilder().build();
    }

    /**
     * 创建 Sharding JDBC DataSource
     *
     * @param ds1DataSource
     * @param ds2DataSource
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSource shardingDataSource(@Qualifier("ds1DataSource") DataSource ds1DataSource,
                                         @Qualifier("ds2DataSource") DataSource ds2DataSource) throws SQLException {
        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("db0", ds1DataSource);
        dataSourceMap.put("db1", ds2DataSource);

        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(getOrderItemTableRuleConfiguration());

        // 获取数据源对象
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentHashMap(0), new Properties());
    }

    /**
     * 构建读写分离数据源, 读写分离数据源实现了DataSource接口, 可直接当做数据源处理. masterDataSource0, slaveDataSource00, slaveDataSource01
     * 等为使用DBCP等连接池配置的真实数据源
     *
     * @return
     */
    @Bean
    public DataSource readSplitWrite(@Qualifier("ds1DataSource") DataSource ds1DataSource,
                                     @Qualifier("ds2DataSource") DataSource ds2DataSource,
                                     @Qualifier("ds3DataSource") DataSource ds3DataSource,
                                     @Qualifier("ds4DataSource") DataSource ds4DataSource,
                                     @Qualifier("ds5DataSource") DataSource ds5DataSource,
                                     @Qualifier("ds6DataSource") DataSource ds6DataSource) throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>(6);
        dataSourceMap.put("masterDataSource0", ds1DataSource);
        dataSourceMap.put("slaveDataSource00", ds2DataSource);
        dataSourceMap.put("slaveDataSource01", ds3DataSource);

        dataSourceMap.put("masterDataSource1", ds4DataSource);
        dataSourceMap.put("slaveDataSource10", ds5DataSource);
        dataSourceMap.put("slaveDataSource11", ds6DataSource);

        // 通过ShardingSlaveDataSourceFactory继续创建ShardingDataSource
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getMasterSlaveRuleConfigs().add(getMasterSlaveRule0());
        shardingRuleConfig.getMasterSlaveRuleConfigs().add(getMasterSlaveRule1());

        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentHashMap(0), new Properties());
    }

    /**
     * 配置 Order表 规则
     *
     * @return
     */
    private TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration orderTable = new TableRuleConfiguration();
        orderTable.setLogicTable("t_order");
        orderTable.setActualDataNodes("db0.t_order_0, db0.t_order_1, db1.t_order_0, db1.t_order_1");
        // 配置分库策略
        orderTable.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "db${user_id % 2}"));
        // 配置分表策略
        orderTable.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_${order_id % 2}"));
        return orderTable;
    }

    /**
     * 配置 OrderItem表 规则
     *
     * @return
     */
    private TableRuleConfiguration getOrderItemTableRuleConfiguration() {
        TableRuleConfiguration orderItemTable = new TableRuleConfiguration();
        orderItemTable.setLogicTable("t_order_item");
        orderItemTable.setActualDataNodes("db0.t_order_item_0, db0.t_order_item_1, db1.t_order_item_0, db1.t_order_item_1");
        // 配置分库策略
        orderItemTable.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "db${user_id % 2}"));
        // 配置分表策略
        orderItemTable.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_item_${order_id % 2}"));
        return orderItemTable;
    }

    /**
     * 构建读写分离配置
     *
     * @return
     */
    private MasterSlaveRuleConfiguration getMasterSlaveRule0() {
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig.setName("ds_0");
        masterSlaveRuleConfig.setMasterDataSourceName("masterDataSource0");
        masterSlaveRuleConfig.getSlaveDataSourceNames().add("slaveDataSource00");
        masterSlaveRuleConfig.getSlaveDataSourceNames().add("slaveDataSource01");
        return masterSlaveRuleConfig;
    }

    /**
     * 构建读写分离配置
     *
     * @return
     */
    private MasterSlaveRuleConfiguration getMasterSlaveRule1() {
        MasterSlaveRuleConfiguration masterSlaveRuleConfig1 = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig1.setName("ds_1");
        masterSlaveRuleConfig1.setMasterDataSourceName("masterDataSource1");
        masterSlaveRuleConfig1.getSlaveDataSourceNames().add("slaveDataSource10");
        masterSlaveRuleConfig1.getSlaveDataSourceNames().add("slaveDataSource11");
        return masterSlaveRuleConfig1;
    }

}
