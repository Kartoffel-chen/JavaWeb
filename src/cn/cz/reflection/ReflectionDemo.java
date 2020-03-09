package cn.cz.reflection;

import cn.cz.domain.Person;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/**
 * @author Kartoffel
 * @create 2020-03-09-23:03
 */
public class ReflectionDemo {
    public static void main(String[] args) throws Exception {

        /*
        * 获取功能 :
            1. 获取成员变量
                * Field[] getFields()---获取全部public修饰的成员变量
                * Field getField(String name)---获取指定名称的public成员变量

                * Field[] getDeclaredFields()---获取所有成员变量(不考虑修饰符)
                * Field getDeclardField(String name)---获取所有指定名称的成员变量(不考虑修饰符)
            2. 获取构造方法
                * Constructor<?>[] gerConstructors()
                * Constructor<T> gerConstructors(类<?>... parameterType)

                * Constructor<T> gerDeclaredConstructors(类<?>... parameterType)
                * Constructor<?>[] gerDeclaredConstructors()
            3. 获取成员方法
                * Method[] getMethods()
                * Method getMethod(String name,类<?>... parameterType)

                * Method[] getDeclaredMethods()
                * Method getDeclaredMethod(String name,类<?>... parameterType)
            4. 获取类名
                * String getName()
         */

        Person person = new Person();
        Class personClass = person.getClass();

        //1. Field[] getFields()---获取全部public修饰的成员变量
        Field[] field = personClass.getFields();
        for (Field field1 : field) {
            System.out.println(field1);
        }
        System.out.println("---------------------------------------");

        //2. Field getField(String name)---获取指定名称的public成员变量
        Field field1 = personClass.getField("a");
        field1.set(person,"陈卓");   //对获取的成员变量进行赋值
        System.out.println(person);
        System.out.println("---------------------------------------");

        //3.Field[] getDeclaredFields()---获取所有成员变量(不考虑修饰符)
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("----------------------------------------");

        //操作
        Field b = personClass.getDeclaredField("b");
        //由于修饰符的原因,不能直接操作
        b.setAccessible(true);
        Object o = b.get(person);
        System.out.println(o);
        b.set(person,"沉着");
        System.out.println(person);

    }
}
