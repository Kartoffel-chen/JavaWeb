package cn.cz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Kartoffel
 * @create 2020-03-13-14:58
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        // 1. 导入驱动jar包
        // 2.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        // 3.获取数据库的连接对象
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "1414524058");

        // 4.定义sql语句
        String sql = "update student set age = 20 where id = 1";

        // 5.获取执行sql对象
        Statement statement = root.createStatement();

        // 6.执行方法
        int i = statement.executeUpdate(sql);

        // 7.处理结果
        System.out.println(i);

        // 8.释放资源
        statement.close();
        root.close();
    }
}
