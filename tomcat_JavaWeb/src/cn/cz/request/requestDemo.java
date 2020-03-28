package cn.cz.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kartoffel
 * @create 2020-03-23-11:40
 */
@WebServlet("/cn/cz/request")
public class requestDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码
        request.setCharacterEncoding("utf-8");

        String userName = request.getParameter("userName");
        System.out.println(userName);

//        //获取数据名称
//        Map<String, String[]> parameterMap = request.getParameterMap();
//
//        Set<String> keySet = parameterMap.keySet();
//        for (String name : keySet) {
//            System.out.println(name);
//            String[] value = parameterMap.get(name);
//            for (String string : value) {
//                System.out.println(string);
//            }
//
//        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doPost(request,response);
    }
}
