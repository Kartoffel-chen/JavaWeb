package cn.cz.jdbc;

import com.mysql.cj.xdevapi.SelectStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Kartoffel
 * @create 2020-03-16-21:46
 */
public class InsertDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "1414524058");
            //3. sql语句
            String sql = "insert into stu values (3,15310173757)";
            //4. 获取执行sql对象
            statement = connection.createStatement();
            //5. 执行语句
            int number = statement.executeUpdate(sql);
            if (number > 0) {
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //避免空指针异常
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
