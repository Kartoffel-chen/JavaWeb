package cn.cz.web.servlet;

import cn.cz.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Kartoffel
 * @create 2020-03-24-11:54
 */
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应字符集
        response.setContentType("text/html;charset=utf-8");
        //获取request域中共享的数据
        User user = (User) request.getAttribute("user");
        //打印输出
        if (user != null) {
            response.getWriter().write("登陆成功," + user.getUserName() + ",欢迎你");
        }

        //设置cookie
        Cookie[] cookies = request.getCookies();
        //没有找到cookies的值为lastTime
        boolean flag = false;

        //cookie不为空
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //获取cookie值名
                String name = cookie.getName();
                //判断cookie名是否是lastTime
                if ("lastTime".equals(name)) {
                    flag = true;
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("上次登录时间 : " + value);
                    //获取系统时间
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String format = simpleDateFormat.format(date);
                    format = URLEncoder.encode(format, "utf-8");

                    //覆盖cookie值
                    cookie.setValue(format);
                    response.addCookie(cookie);
                    //设置cookie的生命周期一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    break;
                }
            }
        }

        //没有找到,说明第一次访问
        if (flag == false || cookies == null || cookies.length == 0) {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String format = simpleDateFormat.format(date);
            format = URLEncoder.encode(format, "utf-8");

            //首次访问
            response.getWriter().write("首次登陆");
            //覆盖cookie值
            Cookie cookie = new Cookie("lastTime",format);
            response.addCookie(cookie);
            //设置cookie的生命周期一个月
            cookie.setMaxAge(60 * 60 * 24 * 30);


        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
