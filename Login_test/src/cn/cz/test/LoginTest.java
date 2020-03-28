package cn.cz.test;

import cn.cz.dao.UserDao;
import cn.cz.domain.User;
import org.junit.Test;

/**
 * @author Kartoffel
 * @create 2020-03-24-10:53
 */
public class LoginTest {

    @Test
    public void login(){
        User user = new User();
        user.setUserName("baby");
        user.setPassword("1414524058");

        UserDao ud = new UserDao();
        User uu = ud.login(user);
        System.out.println(uu);
    }

}
