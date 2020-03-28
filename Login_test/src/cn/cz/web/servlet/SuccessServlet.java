package cn.cz.web.servlet;

import cn.cz.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kartoffel
 * @create 2020-03-24-11:54
 */
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取request域中共享的数据
        User user = (User)request.getAttribute("user");

        //设置编码
        if(user!=null){
            response.setContentType("text/html;charset=utf-8"); ;
            response.getWriter().write("登陆成功,"+user.getUserName() +",欢迎你");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
