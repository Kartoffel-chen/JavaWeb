package cn.cz.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 * @author Kartoffel
 * @create 2020-03-26-10:09
 */
@WebServlet("/response01")
public class ResponseDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("运行demo1");
//        //1. 设置状态码(302)
//        resp.setStatus(302);
//        //2. 设置相应头
//        resp.setHeader("location","/tomcat/response02");

        // 方法二
        resp.sendRedirect("/tomcat/response02");
    }
}
