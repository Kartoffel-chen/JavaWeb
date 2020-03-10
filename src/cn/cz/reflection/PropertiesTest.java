package cn.cz.reflection;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架测试
 * @author Kartoffel
 * @create 2020-03-10-9:44
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意对象,调用任意方法
        // 不改变代码


        // 1.加载配置信息
        // 1.1创建配置对象
        Properties properties = new Properties();

        // 1.2加载配置文件,转换成一个集合
        // 1.2.1获取class目录下的配置文件
        ClassLoader classLoader = PropertiesTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);

        // 2.获取配置文件信息
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        // 3.加载该类进内存
        Class clazz = Class.forName(className);

        // 4.创建对象
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // 5.获取方法对象
        Method method = clazz.getMethod(methodName);

        method.invoke(obj);

    }
}
