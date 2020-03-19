package cn.cz.jdbc;

import cn.cz.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Kartoffel
 * @create 2020-03-18-14:02
 */
public class PayTest {
    public static void main(String[] args) {

        try {
            //获取数据连接
            Connection connection = JdbcUtils.getConnection();
            //sql语句
            String sql1 = "update set number";

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
