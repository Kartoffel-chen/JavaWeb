package cn.cz.reflection;

import cn.cz.domain.Person;

/**
 * 获取反射测试
 * @author Kartoffel
 * @create 2020-03-09-22:32
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {

        /**
         *     1. Class.forName("全类名") : 将字节码文件加载进内存,返回class对象
         *         * 多用于配置文件,将类名定义在配置文件中.读取文件,加载类
         *     2. 类名.class : 通过类名的属性class获取
         *         * 多用于参数的传递
         *     3. 对象.getClass() : getClass()方法在Object类中定义
         *         * 多用于对象的获取字节码的方式
         */

        //Class.forName("全类名")
        Class clazz1 = Class.forName("cn.cz.domain.Person");
        System.out.println(clazz1);

        //类名.class
        Class clazz2 = Person.class;
        System.out.println(clazz2);

        //对象.getClass()
        Person p = new Person();
        Class clazz3 = p.getClass();
        System.out.println(clazz3);
    }
}
