package cn.cz.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author kartoffel
 */
// 浏览器直接请求资源时调用该过滤器
@WebFilter(value="/*",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo2 implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("拦截执行");
        chain.doFilter(req, resp);
        System.out.println("");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
