
## Junit 单元测试:


* 测试分类
    1.黑盒测试 : 不需要写代码,给输入值,看程序是否能输出期望的值
    2.白盒测试 : 需要写代码,关注程序具体的执行流程

* Junit使用
    * 步骤
        1. 定义一个测试类(测试用例)
            * 建议 :
                * 测试类名:被测试的类名Test
                * 包名 : xxx.xxx.xx.test
        2. 定义测试方法 : 可以独立运行
            * 建议 :
                * 方法名 : test测试的方法名
                * 返回值 : void
                * 参数列表 : 空参
        3. 给方法@Test注解
        4. 导入Junit依赖环境
    * 判断结果:
        * 红色 : 表示测试失败
        * 绿色 : 表示测试成功
        * 一般我们会使用断言操作来处理结果
            * Assert.assertEquals(期望的结果,计算的结果);

    * 补充 :
        * @Before :
            * 修饰的方法会在测试方法之前被自动执行
            *  用于资源申请
        * @After :
            * 修饰的方法会在测试方法之后被自动执行
            * 用于资源释放