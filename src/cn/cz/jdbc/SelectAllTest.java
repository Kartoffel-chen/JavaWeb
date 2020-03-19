package cn.cz.jdbc;


import cn.cz.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * @author Kartoffel
 * @create 2020-03-17-9:05
 */
public class SelectAllTest {
    public static void main(String[] args) {
        List<Customers> list = selectAll();
        for (Customers customers : list) {
            System.out.println(customers);
        }

    }

    public static List<Customers> selectAll(){
        //创建一个集合
        List<Customers> list = new ArrayList<>();
        // 接收数据库连接对象
        Connection connection = null;
        // 接收执行对象
        Statement statement = null;
        // 查询对象
        ResultSet resultSet = null;

        try {
           connection = JdbcUtils.getConnection();

            // 3.查询语句
            String sql = "select * from customers";

            // 4.获取执行对象
            statement = connection.createStatement();

            // 5.执行语句
            resultSet = statement.executeQuery(sql);

            // 6.循环装载
            while(resultSet.next()){
                // 获取第一列第一个
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birth = resultSet.getDate("birth");
                Customers customers = new Customers(id,name,email,birth);
                list.add(customers);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(resultSet,statement,connection);
        }
        return list;
    }
}
