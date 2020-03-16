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
        5. 获取执行sql语句的对象 Statement
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
    5. PreparedStatement : 