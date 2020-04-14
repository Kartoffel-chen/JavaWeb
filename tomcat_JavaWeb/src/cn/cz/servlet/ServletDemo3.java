package cn.cz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取请求行数据
 * @author Kartoffel
 * @create 2020-03-23-10:14
 */
@WebServlet("/requestDemo")
public class ServletDemo3 extends HttpServlet {

    /**
     *  1. 获取请求方式 : GET
     *      * String getMethod()
     *  2. (*)获取虚拟目录 :
     *      * String getContextPath()
     *  3. 获取Servlet路径 : /demo
     *      * String getServletPath()
     *  4. 获取get方法请求参数 : name=zhanshang
     *      * String getQuestString()
     *  5. (*)获取请求URI,URL
     *      * String getRequestURI() :
     *      * StringBuffer getRequestURL : http://localhost/test/demo
     *  6. 获取协议版本 : HTTP/1.1
     *      * String getProtocol()
     *  7. 获取客户机ip地址
     *      * String getRemoteAddr()
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求方式
        String method = req.getMethod();
        System.out.println(method);

        //2. (*)获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //3. 获取Servlet路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);

        //4. 获取get方法请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //5. (*)获取请求URI,URL
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);

        //6. 获取协议版本
        String protocol = req.getProtocol();
        System.out.println(protocol);
        //7. 获取客户机ip地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
