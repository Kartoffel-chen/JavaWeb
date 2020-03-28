package cn.cz.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类,使用Druid连接池
 * @author Kartoffel
 * @create 2020-03-24-10:25
 */
public class JdbcUtil {
    private static DataSource ds;


    static{
        try {
            // 1.加载配置文件
            Properties properties = new Properties();
            InputStream resourceAsStream = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);

            // 2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    /**
     * 获取连接Connection对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 获取连接池对象
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
