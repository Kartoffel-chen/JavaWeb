package cn.cz.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Kartoffel
 * @create 2020-03-19-9:30
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 1. 导入jar包
        // 2. 定义配置文件
        //      * 是properties形式的
        //      * 可以交任意名称,可以放在任意目录下
        // 3. 记载配置文件 Properties
        Properties properties = new Properties();
        InputStream resourceAsStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        // 4. 获取数据库连接词对象 : 通过工厂类来获取 DruidDataSourceFactory
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 5. 获取连接 : getConnection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }
}
