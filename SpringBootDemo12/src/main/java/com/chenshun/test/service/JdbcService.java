package com.chenshun.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: mew <p />
 * Time: 18/4/3 09:30  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Service
public class JdbcService {

    @Autowired
    @Qualifier("shardingDataSource")
    private DataSource shardingDataSource;

    @Autowired
    @Qualifier("ds1DataSource")
    private DataSource ds1DataSource;

    public void printCommon() {
        String sql = "select * from t_order_0 where user_id = ? and order_id = ?";
        try (Connection conn = ds1DataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, 11002);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getInt(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printSomeData() {
        String sql = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id WHERE o.user_id=? AND o.order_id=?";
        try (Connection conn = shardingDataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, 11002);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getInt(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printDataFromMultiDatabaseData() {
        String sql = "select * from t_order where user_id = ? and order_id = ?";
        try (Connection conn = shardingDataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, 11002);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getInt(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
