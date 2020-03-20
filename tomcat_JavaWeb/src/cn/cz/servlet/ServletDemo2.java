package cn.cz.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author Kartoffel
 * @create 2020-03-20-19:37
 */
@WebServlet("/demo2")
public class ServletDemo2 implements Servlet{
    /**
     * 初始化方法
     * 在Servlet被创建时,执行,只能执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    /**
     * 获取ServletConfig对象
     * Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次Servlet被访问时,执行.多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("2341313245");
    }

    /**
     * 获取Servlet的一些版本,信息,作者等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方式
     * 在服务器正常关闭时,执行,一次
     */
    @Override
    public void destroy() {

    }
}
