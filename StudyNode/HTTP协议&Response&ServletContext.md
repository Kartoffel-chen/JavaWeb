## HTTP协议:
    1. 请求消息 : 客户端发送给服务端的数据
        * 数据格式 : 
            1. 请求行
            2. 请求头
            3. 请求空行
            4. 请求体
    2. 相应消息 : 服务端发送给客户端的数据
        * 数据格式 : 
            1. 相应行
                HTTP/1.1 200 
                1.  组成 : 协议/版本 相应状态码 状态码描述
                2. 相应状态码 : 服务器告诉客户端浏览器本次请求的相应的一个状态
                    1. 状态码都是3位数字
                    2. 分类
                        1. 1xx 服务器接收客户端消息,但没有接收完成,等待一段时间后,发送1xx
                        2. 2xx 成功 200
                        3. 3xx 重定向: 302(重定向) 304(访问缓存)
                        4. 4xx 客户端错误: 
                            * 404 (请求路径没有对应的资源)
                            * 405 请求的方式没有对应的doGet或者doPost方法 
                        5. 5xx 服务器端错误 : 500 (服务器内部出现异常)
                        
            2. 相应头 : 
                Content-Type: text/html;charset=utf-8
                    - 服务器告诉客户端本次相应的数据格式以及编码格式
                Content-Language: zh-CN
                    - 以什么格式打开相应体数据
                        *   值
                            1. in-line : 默认值,在当前页面打开
                            2. attachment;filename=xxx : 以附件形式打开相应体,文件下载
                Content-Length: 1674
                Date: Thu, 26 Mar 2020 01:43:50 GMT
                
            3. 相应空行
            4. 相应体
## Response对象
    1. 功能: 设置相应消息
        1. 设置相应行
            * setStatus(int SC)
        2. 设置相应头
            * setHeader(String name , String value)
        3. 设置相应体
            * 使用步骤 : 
                1. 获取输出流
                    * 字符输出流 : printwriter getWriter()
                    * 字节输出流 : ServletOutputStream getOutputStream()
                2. 使用输出流
                
    2. 案例:
        1. 完成重定向
            * 重定向: 也是一种资源跳转
            * 代码实现
                方法一：
                    //1. 设置状态码(302)
                    resp.setStatus(302);
                    //2. 设置相应头
                    resp.setHeader("location","/tomcat/response02");
                方法二： （简单的重定向）
                    resp.sendRedirect("/tomcat/response02");
            * 重定向特点:
                1. 地址栏发生变化
                2. 重定向可以访问其他站点(服务器)的资源
                3. 重定向是两次请求
            * 转发的特点:
                1. 转发地址路径一样
                2. 转发只能访问当前服务器下的资源
                3. 转发是一次请求
                    
        2. 服务器输出字符数据到浏览器
        3. 服务器输出字节数据到浏览器
        4. 验证码案例