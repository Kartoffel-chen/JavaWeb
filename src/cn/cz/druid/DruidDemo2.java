package cn.cz.druid;

import cn.cz.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Kartoffel
 * @create 2020-03-19-10:14
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取数据库连接对象
            connection = JDBCUtil.getConnection();
            //sql语句
            String sql = "insert into user value (null,?,?)";
            //执行
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"李四");
            preparedStatement.setString(2,"bzjyxyc");
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(preparedStatement,connection);
        }
    }
}
