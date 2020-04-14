package cn.cz.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis 测试类
 * @author Kartoffel
 * @create 2020-04-14-15:51
 */
public class JedisDemo1 {
    private Jedis jedis = new Jedis("localhost");
    /**
     * 快速入门
     */
    @Test
    public void Test(){
        //1. 获取连接
        Jedis jedis = new Jedis("localhost");
        //2. 操作
        jedis.set("username","1321");
    }

    @Test
    /**
     * 数据库结构操作
     */
    public void Test1(){
        //1. 获取连接
        Jedis jedis = new Jedis("localhost");
        //2. 操作
        jedis.hset("user","username","zhangsan");
        jedis.hset("user","password","1111");
        jedis.hset("user","age","123");

        //获取hash
        String name = jedis.hget("user", "username");
        System.out.println(name);

        //获取mao表中所有的元数
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            //获取value
            String s = user.get(key);
            System.out.println(key +':'+ s);
        }

    }

    /**
     * list 数据机构操作
     */
    @Test
    public void Test2(){
        //1. 获取连接
        Jedis jedis = new Jedis("localhost");
        //2. 操作
        jedis.lpush("list","a","b","c");
        jedis.rpush("list","a","b","c");
        //获取
        List<String> list = jedis.lrange("list", 0, -1);
        System.out.println(list);

    }

    /**
     * jedis连接池使用
     */
    public void Test3(){
        //创建连接池对象
        JedisPool jedisPool = new JedisPool("localhost");
        Jedis jedis = jedisPool.getResource();
        //使用
        jedis.set("hh","sada");

        //关闭 归还到连接池

    }
}
