## tomcat : web服务器软件
1. 下载 : 百度收缩Tomcat
2. 启动 : bin目录下 startup.bat
   * 可能遇到的问题 : 
       1. 黑窗口一闪而过 : 
           * 原因 : 没有正确配置JAVA_HOME环境变量
           * 解决方案 : 正确配置
       2. 启动报错:
           * 暴力 : 找到占用的端口号,并且找到对应的进程,杀死该进程
               * cmd --> netstat -ano
           * 温柔 : 修改自身端口号
3. 访问 : localhost:8080 
4. 关闭 : 
   1. 正常关闭 : 
       * bin目录下 shutdow.bat
       * ctrl + c
   2. 强制关闭 :
       * 点击窗口xx
5. 配置 : 
   * 部署项目的方式 : 
       1. 直径将项目放到webapps目录下
           * /项目包名:项目的访问路径 -->虚拟路径
           * 简化部署 : 将项目打成一个war包,在将war放在webapps下
               * war包会自动解压        

       2. 配置conf/server.xml文件
           * 在<Host>标签体中配置
           * <Context docBase="需要执行的项目文件夹" path="文件路径"/>
           * docBase : 项目存放的路径
           * path : 虚拟目录
       3. 在conf\caralina\localhost创建任意名称的xml文件,在文件中编写
           * <Context docBase=项目目录地址
   * 静态项目和动态项目:
       1. 目录结构
           * java动态项目的目录结构 :
               * 项目的根目录   
                   * WEB-INF目录 :
                       * web.xml : web项目的核心配置文件
                       * classes目录 : 放置字节码文件的目录
                       * lib目录 : 放置依赖的jar包
## Servlet : server applet
1. 概念 : 运行在服务端的小程序
    * servlet 就是一个接口,定义了Java类被浏览器访问到(tomcat识别)的规则
    * 将来我们自定义一个类,实现Servlet接口,复写方法
2. 快速入门 : 
    1. 创建javaEE项目
    2. 定义一个类,实现Servlet接口
    3. 实现接口中的抽象方法
    4. 配置Servlet
        * 在web.xml中配置 :
        * ```text
            <!-- 配置Servlet  -->
            <servlet>
                <servlet-name>Kartoffel</servlet-name>
                <servlet-class>cn.cz.servlet.ServletDemo</servlet-class>
            </servlet>
            <servlet-mapping>
                <servlet-name>Kartoffel</servlet-name>
                <url-pattern>/Kartoffel</url-pattern>
            </servlet-mapping>
          ```
    5. 执行原理 : 
        1. 当服务器接收到客户端浏览器的请求后,会解析请求URL路径,获取访问的Servlet的资源路径
        2. 查找web.xml文件,是否由对应的<url-pattern>标签体内容
        3. 如果有,则会找到对应的<Servlet-class>全类名
        4. tomcat会将字节码文件加载进内存,并且创建其对象
        5. 调用其方法
    6. Servlet中的生命周期:
        1. 被创建 : 执行init方法,一次
            * servlet什么时候被创建
                * 默认情况下,第一次被访问时,Servlet被创建
                * 可以配置执行Servlet的创建时机
        2. 提供服务 : 执行service方法,执行多次
            * 每次被访问都会执行一次
        3. 被销毁 : 执行destroy方法,一次
            * Servlet被销毁时执行.服务器关闭时,Servlet被销毁
            * 只有正常关闭,才会被执行
            * destroy方法在Servlet被销毁之前被执行(遗言,在断气之前),一般用于释放资源
            
    7. Servlet3.0:
        1. 好处 : 
            * 支持注解配置,可以不需要web.xml了
        2. 步骤 :
            1. 创建JavaEE项目,选择Servlet的版本3.0以上,可以不创建web.xml
            2. 定义一个类,实现Servlet接口
            3. 复写方法
            4. 在类上使用@WebServlet注解,进行配置
                * @WebServlet("资源路径");