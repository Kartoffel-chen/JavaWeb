## Servlet
    1. 概念
    2. 步骤
    3. 执行原理
    4. 生命周期
    5. Servlet3.0 注解配置
    6. Servlet的体系结构
        Servlet -- 接口
               |
        GenericServlet -- 抽象类
               |
        HttpServlet -- 抽象类
    
        * GenericServlet : 将Servlet接口中其他方法做了默认实现,只将Servlet()方法作为抽像
            * 将来定义Servlet类时,可以继承GenericServlet,实现service()方法即可
        * HTTPServlet : 对http协议的一种封装 (推荐使用)
            * 复写doGet/doPost方法
    7. Servlet相关配置
        1. urlpertten : 访问路径
            1. 一个Servlet可以定义多个访问路径
            2. 路径定义规则 : 
                1. /xxx
                2. /xxx/xxx : 多层
                3. 
    
    
## HTTP协议
    1. 概念: 超文本传输协议
        * 传输协议 : 定义了,客户机和服务器端通信时,发送的数据格式
        * 特点: 
            1. 基于TCP/IP的高级协议
            2. 默认端口号 : 80
            3. 基于请求/响应模型的:一次请求对应一次响应
            4. 无状态的 : 每次请求之间项目独立,不能交互数据
        * 历史版本
            1. 1.0 每次请求都会建立一个新的连接
            2. 1.1 复用连接
    2. 请求消息数据格式
        1. 请求行
            请求方式 : 请求url 请求协议/版本
            * 请求方式 :
                * get : 
                    1. 请求参数在请求行中,在url后
                    2. 请求的url长度有限制
                    3. 不太安全
                * post :    
                    1. 请求参数在请求体中
                    2. 请求的url长度没有限制
                    3. 相对安全
        2. 请求头
            请求头名称 : 请求值
        3. 请求空行
            空行
        4. 请求体(正文)
        
    3. 相应消息数据格式
    
    
## Request : 
    1. request对象和response对象的原理
        1. request和response对象是由服务器拆个年间的
        2. request独享是来获取请求信息,response对象是来设置响应信息
    2. request : 获取请求消息
    3. request功能:
        1. 获取请求行数据
            * GET /test/demo1?name=zhangshan HTTP/1.1
            * 方法 : 
                1. 获取请求方式 : GET    
                    * String getMethod()
                2. (*)获取虚拟目录 : /test
                    * String getContextPath()
                3. 获取Servlet路径 : /demo
                    * String getServletPath()
                4. 获取get方法请求参数 : name=zhanshang
                    * String getQuestString()
                5. (*)获取请求URI,URL
                    * String getRequestURI() : /test/demo
                    * StringBuffer getRequestURL : http://localhost/test/demo
                6. 获取协议版本 : HTTP/1.1
                    * String getProtocol()
                7. 获取客户机ip地址
                    * String getRemoteAddr()
        2. 获取请求头数据
            * 方法
                * (*)String getHeader(String name) : 通过请求头的名称获取请求头的值
                * Enumeration<String> getHeaderNames() : 获取所有1请求头名称
        3. 获取请求体数据: 
            * 请求体 : 只有post请求方式,才有请求体,在请求体封装了post请求得请参数
            * 步骤 : 
                1. 获取流对象
                    BufferedReader getReader() : 获取字符输入流,只能操作字符数据
                    ServletInpitStream getInputStream() : 获取字节输入流,可以操作所有类型数据
                        * 在文件上传知识点后讲解
                    
                2. 在从流对象中拿数据
    3. 其他功能 
        1. 获取请求参数通用方式 : 不论get还是post都可以使用下列方法来获取请求参数
            * String getParameter(String name) : 根据阐述明称获取参数值
            * String[] getParamenterValues(String name) : 根据参数名获取参数值得数组
            * getParameterNames(0:获取所有请求得参数名称
            * Map<String,String> getParameterMap();
            
            ! 中文乱码问题:
                * get方法 tomcat8 已经得到解决
                * post方法 : 会乱码
                    * 解决 : 在获取参数前,设置request得编码
                    * request.setCharacterEncoding("UTF-8");
        2. 请求转发 : 一种在服务器内部得资源跳转方式
            1. 步骤 : 
                1. 通过request对象获取请求转发器对象 : RequestDispatcher getRequestDispatcher(String path)
                2. 使用RequestDispatcher对象来进行转发 : forward(ServletRequest request,ServletResponse response)
            2. 特点 : 
                1. 浏览器地址路径不发生变化
                2. 只能转发到当前服务器内部资源中
                3. 转发是一次请求  
        3. 共享数据 : 
            * 域对象 : 一个有作用范围对象得对象,可以在范围内共享数据
            * request域: 代表一次请求的范围,一般用于请求转发的多个资源
            * 方法 :  
                * void setAttribute(String name,Object obj) : 存储数据
                * Object getAttribute(String name) : 通过键获取值
                * void removeAttribute(String name) : 通过键移除值
            
        4. 获取ServletContext 
            * ServletContext getServletContext()