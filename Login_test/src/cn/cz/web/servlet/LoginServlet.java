package cn.cz.web.servlet;

import cn.cz.dao.UserDao;
import cn.cz.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Kartoffel
 * @create 2020-03-24-11:34
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
//
//        //获取请求
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("passWord");
//
//        //封装User
//        User loginUser = new User();
//        loginUser.setUserName(userName);
//        loginUser.setPassword(password);
        Map<String, String[]> parameterMap = request.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,parameterMap);
            System.out.println(loginUser);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用UserDao中的Login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        //判断放回值
        if (user == null) {
            //登陆失败,跳转到FailServlet显示 : 登陆失败,用户名或密码错误
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else {
            //登陆成功跳转到SuccessServlet显示 : 登陆成功!用户名,欢迎你
            //存储数据
            request.setAttribute("user",user);
            //转发
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

