# Filter 过滤器
1. 概念
    1. 生活中的过滤器: 净水器,空气净化器
    2. web中的过滤器: 当访问服务器的资源时,过滤器可以将请求拦截下来,完成一些特殊的功能
    3. 过滤器的作用:
    * 一般用于完成通用的操作,如: 登陆验证,统一编码处理,敏感字符过滤...
2. 快速入门 :
    1. 步骤: 
        1. 定义一个类,实现接口Filter
        2. 复写方法
        3. 配置拦截路径
        ```text
            @WebFilter("index.jsp")
            public class FilterDemo1 implements Filter {
                @Override
                public void init(FilterConfig filterConfig) throws ServletException {
                
                }
                
                @Override
                public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                  System.out.println("Filter被执行....");
                }
                
                @Override
                public void destroy() {
                
                }
            }
        ```
3. 过滤器细节:
    1. web.xml配置
    ```text
       <filter>
            <filter-name>demo1</filter-name>
            <filter-class>cn.cz.filter.FilterDemo1</filter-class>
        </filter>
    
        <filter-mapping>
            <filter-name>demo1</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
    ```
    2. 过滤器执行流程
        1. 执行过滤器
        2. 执行放行后的资源
        3. 回来执行过滤器放行代码下面的代码
    3. 过滤器生命周期
        1. init : 在服务器启动后,会创建Filter对象,然后调用init方法.只执行一次,用于加载资源
        2. doFilter : 每次请求被拦截资源时,会被执行.执行多次
        3. destroy : 在服务器关闭后,Filter对象被销毁,如果服务器是正常关闭,则会执行.用于释放资源
    4. 过滤器配置详解
        1. 拦截路劲配置: (表示当需要执行拦截路径中的文件时候,都会出发过滤器,然后由过滤器决定是否通过)
            * 具体资源路径: /index.jsp
            * 目录拦截: /user/*    
                * 访问/user下的所有资源时,被执行
            * 后缀名拦截: *.jsp
                * 访问所有后缀为.jsp的资源
            * 拦截所有资源: /*
        2. 拦截方式配置 : 资源被访问的方式
            * 注解配置 :
                * 设置dispatcherType属性
                    1. request : 默认值,浏览器直接请求资源
                    2. forward : 转发访问资源
                    3. include : 包含访问资源
                    4. error : 错误跳转资源
                    5. async : 异步访问资源
            * web.xml配置
                * 设置<dispatcher></dispatcher>标签即可
    
    5. 过滤器链(配置多个过滤器)
        * 执行顺序: 如果有两个过滤器: 1--2
            * 1执行
            * 2执行
            * 执行资源
            * 2执行
            * 1执行
        * 过滤器先后顺序问题:
            1. 注解配置: 按照类名的字符串比较规则比较,值小的先执行
                * 如: AFilter 和 BFilter,A先执行
            2. web.xml配置: 谁定义在上面,谁先执行
            
# Listener : 监听器
1. 概念 : web的三大机制
    * 事件监听机制:
        1. 事件: 一件事情(鼠标点击)
        2. 事件源: 事件发生的地方
        3. 监听器: 一个对象
        4. 注册监听: 将事件,事件源,监听器绑定在一起,当事件源上发生某个事件后,执行监听器代码
    * ServletContextListener: 监听servletContext对象的创建和销毁
        1. void contextDestroyed(servletContextEvent sce) : ServletContext对象被销毁之前调用
        2. void contextInitialized(servletContextEvent sce) : servletContext对象被创建时候调用