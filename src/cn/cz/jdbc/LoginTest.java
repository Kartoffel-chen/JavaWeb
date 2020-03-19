package cn.cz.jdbc;

import cn.cz.utils.JdbcUtils;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Scanner;

/**
 * prepardeStatement防止sql注入
 *
 * @author Kartoffel
 * @create 2020-03-18-10:53
 */
public class LoginTest {
    public static void main(String[] args) {
        //接收用户输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String user = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        boolean flag = new LoginTest().Login(user, password);
        if (flag) {
            System.out.println("登陆成功");
        } else {
            System.out.println("用户名或密码失败");
        }

    }

    public boolean Login(String name, String password) {
        //有效值判断
        if (name == null && password == null) {
            return false;
        }
        //接收数据库连接对象
        Connection conn = null;
        //接收执行对象
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?serverTimezone=UTC", "root", "1414524058");
            // 3.定义查询
            String sql = "select id from user where name = ? and password = ?";
            // 4.获取执行对象
            pstmt = conn.prepareStatement(sql);

            //赋值
            pstmt.setString(1, name);
            pstmt.setString(2, password);

            resultSet = pstmt.executeQuery();
            return resultSet.next();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet, pstmt, conn);
        }
        return false;
    }
}
