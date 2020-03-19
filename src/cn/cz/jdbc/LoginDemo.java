package cn.cz.jdbc;

import cn.cz.utils.JdbcUtils;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Kartoffel
 * @create 2020-03-17-11:16
 */
public class LoginDemo {

    public static void main(String[] args) {
       //接收用户输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String user = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        boolean flag =new LoginDemo().login(user,password);
        if(flag){
            System.out.println("登陆成功");
        }else{
            System.out.println("用户名或密码失败");
        }
    }


    /**
     * 登陆测试
     * @return 是否登陆成功
     */
    public boolean login(String name,String password){
        //健壮性判断
        if(name == null && password == null){
            return false;
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //获取数据库连接对象
            connection = JdbcUtils.getConnection();
            //查询语句
            String sql = "select * from user where name='"+name+"'and password='"+password+"'";
            //执行对象
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(resultSet,statement,connection);
        }
        return false;
    }

}