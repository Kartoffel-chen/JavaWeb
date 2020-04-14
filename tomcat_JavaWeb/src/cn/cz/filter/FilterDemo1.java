package cn.cz.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Kartoffel
 * @create 2020-03-23-11:40
 */
@WebFilter("/index.jsp")//表示执行这个资源之前都会执行过滤器
public class FilterDemo1 implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("启动执行");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter被执行....");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);


    }

    @Override
    public void destroy() {
        System.out.println("正常关闭服务器调用");
    }
}
