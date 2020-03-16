package cn.cz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Kartoffel
 * @create 2020-03-16-22:11
 */
public class UpdateDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","1414524058");
            //3.修改语句
            String sql = "update stu set phone_number = 123 where id = 3";
            //4. 获取执行对象
            statement = connection.createStatement();
            //5. 执行语句
            int i = statement.executeUpdate(sql);
            System.out.println(i + "语句受影响");
            if (i > 0) {
                System.out.println("执行成功");
            }else {
                System.out.println("执行失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //判断是否空指针
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
