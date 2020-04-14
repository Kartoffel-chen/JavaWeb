## EL表达式
1. 概念 : Expression Language 表达式语言
2. 作用 : 替换和简化jsp页面中的java代码的编写
3. 语法 : ${表达式}
4. 注意: 
    * jsp默认支持el表达式,如果要忽略表达式
        1. 设置jsp中page指令中 : isElIgnored = "true";
            * true : 忽略所有el表达式
        2. \${表达式} : 忽略当前
5. 使用:
    1. 运算
        * 运算符 :
            1. 算术运算符 :  +  - * /(div) %(mod)
            2. 比较运算符 : > < >= <= == !=
            3. 逻辑运算符 : &&(and) ||(or) !(not)
            4. 空运算符 : empty
                * 功能 : 用于判断字符串,集合,数组对象,是否为null并且长度是否为0
                * ${empty list}
                * ${not empty str} : 标识判断字符串,集合,数组对象是否不为null 并且长度>0
    2. 获取值
        * el只能从域对象中获取值
        * 语法 : 
            1. ${域名称,键名} : 从指定域汇总获取指定键的值
                1. pageScope --> pageContext
                2. requestScope --> request
                3. sessionScope --> session
                4. applicationScope --> application(ServletContext)
            * 举例 : 在request域中存储了name = 张三
            * 获取 :
                1. ${requestScope.name}
                2. ${键名} 标识,依次从最小的域中查找是否有该键对应的值,直到找到为止
                
            * 获取 对象,list集合,map集合
                1. 对象 : ${域名称.键名.属性名}
                    * 本质上就是调用getter方法
                2. list集合 : ${域名称.键名[索引]}
                    ```text
                       ${list}<br> --<br>换行  
                       ${list[index]} 添加索引,获取值
                    ```
                3. Map集合 : 
                    1. ${域名.键名.key名}
                    2. ${域名称.键名["key名称"]}            
    3. 隐式对象 : 
        * el表达式中有11个隐式对象
        * pageContext:
            1. 能够获取其余八个对象
                * ${pageContext.request.contextPath}: 动态获取虚拟目录
                

## JSTL
1. 概念 : javaServlet Pages Tag Library jsp标准标签库
    * 是由Apache组织提供的开源的免费的jsp标签
2. 作用 : 用于简化和替换jsp页面上的java代码
    
    
3. 使用步骤 : 
    1. 导入jstl相关jar包
    2. 引入标签库 : taglib指令: <%@ taglib %>
        * <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    3. 使用标签
4. 常用的JSTL标签
    1. if: 相当于if语句
        1. 属性 : 
            * test : 必须属性,接收boolean表达式
                * 如果表达式为true,则显示内容,为false 则不显示
                * 一般情况下mtest属性值结合el表达式一起使用
        2. 注意: 
            * c:if标签没有else情况,只能在定一个c:if
    2. choose : 相当于switch
        1. 格式
        ```text
           <c:choose>
               <c:when test = "判断条件" ></c:when>
               <c:otherwise>默认</c:otherwise>
           </c:choose>
        ```
        2. choose : 相当于switch声明
        3. when : 相当于case
        4. otherwise : 相当于default
        
    3. foreach : 相当于for
        1. 优点
            * 能够完成重复操作
                1. begin : 开始值
                2. end : 结束值
                3. var : 临时变量 
                4. step : 步长
                5. varStatus : 循环状态对象
                *  <c:forEach begin="1" end="10" var="i" step="1">
                ${i}
                </c:forEach>
            * 遍历容器
                1. itrme : 容器对象
                2. var : 容器中元数的临时变量
                3. varStatus : 循环状态对象
                    * index 容器中元数的索引,从0开始
                    * count : 循环次数,从1开始