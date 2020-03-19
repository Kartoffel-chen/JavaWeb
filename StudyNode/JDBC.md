## JDBC
* 概念 : Java DateBase Connectivity java数据库连接, java语言操作数据库
* JDBC本质 : 其实就是官方(sun公司)定义的一套能操作所有关系型数据库的规则,即接口,各个数据库厂商去实现这套接口,提供数据库驱动jar包,我们可以使用这套接口编程,真正执行的代码是  驱动jar包中的类

* 快速入门 : 
    * 步骤 : 
        1. 导入驱动jar包
            * 复制驱动jar包到项目
            * 右键 add as library
        2. 注册驱动
        3. 获取数据库连接对象 Connection
        4. 定义sql
        5. 获取执行sql语句的对象 Statement()
        6. 执行sql,接收返回结果
        7. 处理结果
        8. 释放资源
    * 代码实现 :
        ```text
        // 1. 导入驱动jar包
        // 2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
    
        // 3.获取数据库的连接对象
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "1414524058");
    
        // 4.定义sql语句
        String sql = "update student set age = 100 where id = 1";
    
        // 5.获取执行sql对象
        Statement statement = root.createStatement();
    
        // 6.执行方法
        int i = statement.executeUpdate(sql);
    
        // 7.处理结果
        System.out.println(i);
    
        // 8.释放资源
        statement.close();
        root.close();
        ```
* 详解各个对象 : 
    1. DriverManager : 驱动管理对象
        * 功能 : 
            1. 注册驱动 : 告诉程序该使用那一个数据库驱动jar(步骤可省略)   
                static void registerDriver(Driver driver): 注册与给定的驱动程序 DriverManage
                代码使用: Class.forName("com.mysql.jdbc.Driver");
                
            2. 获取数据连接 : 
                * 方法 : static Connection getConnection(String url,string user, string password)
    2. Connection : 数据库连接对象
        * 功能 : 
            1. 获取执行sql的对象 
                * Statement createStatement()
                * PreparedStatement PrepareStatement(String sql)
            2. 管理事务 :
                * 开启事务 : void serAutoCommit(boolean autoCommit): 调用该方法设置参数为false,即开启事务
                * 提交事务 : commit()
                * 回滚事务 : rollback()
    3. Statement : 执行sql的对象
        * 执行sql
            1. boolean execute(String sql) : 可以执行任意sql(了解)
            2. int exrcuteUpdatre(String sql) : 执行DML(增删改)和DDL(crerate,alter,drop)
                * 返回值 : 影响的行数,可以通过返回值判断是否执行成功
            3. ResultSet executeQuery(String sql) : 执行DQL 查询语句
        * 练习 : 
            1. student表 添加一条记录
            2. student表 修改记录
            3. student表 删除一条记录
    4. ResultSet : 结果集对象
        * next(): 游标向下移动一行
        * getXxx() : 获取数据
            * Xxx 代表数据类型 : int getInt() String getString();
            * 参数:
                1. int 代表列的编号,从1开始 getString(1);
                2. String:代表列的名称 getDouble("balance");
                
        * 练习 : 查询一个表中所有数据,装载集合,然后输出
    5. PreparedStatement : 执行sql的对象
        * sql注入问题 : 在拼接sql是,有一些sql的特殊关键字参与字符串的拼接,会造成安全性问题
            
            1. 输入用户随便,输入密码 a' or 'a' = 'a
            2. sql : 
        * 解决sql注入问题 : 使用preparedStaTEMENT对象来解决
        * 预编译的sql : 参数使用?作为占位符
        * 步骤 : 
        ```text
        1. 导入驱动jar包
            * 复制驱动jar包到项目
            * 右键 add as library
        2. 注册驱动
        3. 获取数据库连接对象 Connection
        4. 定义sql
            * 注意 : sqld的参数使用?作为占位符 例如 : select * from user where username = ? and password = ?;
        5. 获取执行sql语句的对象 PreparedStatement Connecition.preparedStatement(String sql)
        6 给?赋值 : 
           * 方法 : setXxx(参数1,参数2)
               1. 参数1 是?的位置编号,从1开始
               2. 参数2 是?的值
    
        6. 执行sql,接收返回结果
        7. 处理结果
        8. 释放资源
        ```
       * 注意 : 后期都会使用PreparedStatement来完成增删该查的所有操作
            1. 可以防止sql注入
            2. 效率更高
## 抽取JDBC工具类 : JDBCUtils
1. 目的 : 简化书写       
2. 分析 :
    * 注册驱动也抽取
    * 抽取一个方法,获取连接对象
        * 需求 : 不想传递参数,保证工具类的通用性
        * 解决 : 配置文件
    * 抽取一个方法释放资源
    
    
    
## jdbc 控制事务 : 
1. 事务 :一个包含多个步骤的业务操作,如果这个业务操作被多个事务管理,则这个步骤要么同时成功,要么同时失败
2. 操作 :
    * 开启事务
    * 提交事务 
    * 回滚事务
3. 使用Connection对象来管理事务
     * 开启事务 :  serAutoCommit(boolean autoCommit): 调用该方法设置参数为false,即开启事务
        * 在执行sql之前开启事务
     * 提交事务 : commit()
        * 在所有sql执行完提交事务
     * 回滚事务 : rollback()
        * 在catch中回滚事务
