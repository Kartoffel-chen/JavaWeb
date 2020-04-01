# 会话技术
    1. 会话 : 一次会话中包含多次请求和响应
        * 一次会话 : 浏览器第一次给服务器资源发送请求,会话建立,直到有一方断开为止
        * 功能 : 再一次会话的范围内的多次请求间,共享数据 
        * 方式 : 
            1. 客户端会话技术 : cookie
            2. 服务器端会话技术 : Session

## Cookie
    1. 概念 : 客户端会话技术,将数据保存到客户端
    2. 快熟入门 : 
        * 使用步骤
            1. 创建Cookie对象,绑定数据
                * new Cookie(String name , String value)
            2. 发送Cookie对象
                * response.addCookie(Cookie cookie);
            3. 获取Cookie,拿到数据
                * Cookie[] requst.getCookie()
    3. 实现原理
        * 基于相应头set-cookie和请求头cookie实现
    4. Cookie的细节
        1. 一次可不可以发送多cookie?
            * 可以
            * 创建多个Cookie对象,使用response.addCookie()方法多次存放
        2. cookie在浏览器中保存多长时间
            1. 默认情况下,当浏览器关闭,Coolkie数据被销毁
            2. 设置cookie生命周期,持久化存储
                * serMaxAge(int seconds)
                    1. 正数 : 将Cookie数据写到硬盘文件中,持久化存储,cookie存活时间
                        30s,持久存放30s,然后删除
                    2. 负数 : 默认值,关闭
                    3. 零 : 删除cookie
        3. cookie能不能存中文 :
            * 在tomcat 8 之前,不能存储中文
                * 需要将中文数据转码 --- 一般采用URL编码
            * tomcat 8 之后可以
        4. cookie获取的范围多大
            * 假设在一个服务器中,部署了多个web项目,那么在这些项目中Cookie能不能共享
                * 默认不能共享
                * setpath(String path): 设置cookie获取范围,默认情况下,设置当前虚拟目录
                    * 如果要给共享 则将可以设置setpath("/") 
            * 不同的tomcat服务器间cookie共享问题
    5. Cookie的特点和作用
        1. cookie存储数据在客户端浏览器
        2. 浏览器对于单个cookie的大小有限制(4kb)以及对同一个域名下的总cookie数量也有限制(20个)
    
## Session
    1. 概念 : 服务器端会话技术,在一次会话的多次请求间共享数据,将数据保存在服务器端的对象中,httpSession
    2. 快速入门 : 
        1. 获取HttpSession对象:
            * HttpSession session =  request.getSession();
        2. 使用HttpSession对象:
            * Object getAttribute(String name)
            * void SerAttribute(String name,Object value)
            * void removeAttribute(String name)
        3. 原理
            * Session的实现是依赖于Cookie的
        4. 细节 : 
            1. 当客户端关闭后,服务器不关闭,两次获取Session是否为同一个
                * 默认情况下不是
                * 如果希望相同,则可以创建Cookie,键为 JSESSIONID,设置最大存活时间,让cookie持久化 
            2. 客户端不关闭,服务器关闭,两次获取session是否为同一个
                * 不是同一个,但是要确保数据不丢失
                    * session的钝化 :
                        * 在服务器正常关闭之前,将session对象系列化到硬盘上
                    * session的活化 :
                        * 在服务器启动后,将session文件转化为内存中的session对象即可
            3. session的失效时间
                1. 服务器关闭
                2. session对象调用invalidate()
                3. session默认失效时间 30分钟
                    选择性修改配置
                    <session-config>
                        <session-timeout>30</session-timeout>
                    </session-config>    
        5. 特点 : 
            1. session 用于存储一次会话的多次请求的数据,存在服务器端
            2. session可以存储任意类型,任意大小的数据
        
            * session与Cookie的区别 :
                1. session存储数据在服务器端,Cookie在客户端
                2. Session没有数据大小限制,Cookie有
                3. Session数据安全,Coolie相对于不安全
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
                    
## 案例 : 验证码
    1. 