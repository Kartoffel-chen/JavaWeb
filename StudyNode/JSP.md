## JSP入门
    1. 概念 : 
        * java Serve pages : java服务端页面
            * 可以理解为一个特殊的页面,其中即可以直接定义html标签,也可以定义java代码
            * 用于简化书写!!!
    
    2. jsp原理
        * jsp本质上就是一个Servlet
    
    3. jsp的脚本 : jsp定义java代码的方式
        1. <%  Java代码 %> : 定义的java代码,在servlet方法中,servlet可以定义什么,该脚本就可以定义什么   
        2. <%! Java代码 %> : 定义的java代码,在jsp转换后的java类的成员位置
        3. <%= java代码 %> : 定义的java代码,会输出到页面上,输出语句可以定义什么,该脚本就可以定义什么
    
    4. jsp的内置对象    
        * 在jsp页面中不需要获取和创建,可以直接使用的对象
        * jsp一共有9个内置对象
            * request
            * response
            * out : 字符流输出对象,可以将数据输出到页面,和response.getWriter()类似
                * response.getWriter()和out.write()的区别 : 
                    * 在tomcat服务器真正给客户端做出响应之前,会先找response缓冲区数据,在找out缓冲器数据
                    * response.getWriter()数据输出永远在out.write()之前

## JSP进阶
1. 指令
    * 作用 : 用于配置JSP页面,导入资源文件
    * 格式
     <%@ 指令名称 属性名1=属性值1,.......%>
    * 分类 : 
        1. page : 配置JSP页面的
            * contenType : 等同于response.setContentType()
                1. 设置响应体的mime类型以及字符集
                2. 也可以设置当前JSP页面的编码(只能是高级的IDE才能生效,如果使用低级工具,这只能手动设置)
            * import : 用于导入java包
            * errorPage : 当前页面发生异常后,自动跳转到指定的错误页面
            * isErrorPage : 用于标记当前页面是否是错误页面
                * true 是,可以使用内置对象exception
                * false : 否 (默认) ,b不可以使用内置对象exception
                 
        2. include : 页面包含的,导入页面的资源文件
        3. taglib : 导入资源
        
2. 注释
    * html注释
        <!-- --> : 只能注释html
    * jsp注释
        <%-- --%> : 可以注释所有
3. 内置对象
    * 在jsp页面中不需要创建,直接使用的对象
    * 一共有9个
    ```text
           变量名                   真实类型                      作用
        1. pageContext             PageContext               当前页面共享数据,还可以获取其他8个对象
        2. request                 HttpServletRequest        一次请求访问多个资源(转发)
        3. session                 HttpSession               一次会话的多个请求间
        4. application             ServletContext            所有用户间共享数据
        5. response                HttpServletResponse       响应对象
        6. page                    Object                    当前页面的对象(Servlet),this
        7. out                     JsWriter                  输出对象
        8. config                  ServletConfig             Servlet的配置对象
        9. exception               Throwable                 异常对象
    ```
    
