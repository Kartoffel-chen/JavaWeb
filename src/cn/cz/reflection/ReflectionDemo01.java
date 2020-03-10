package cn.cz.reflection;

import cn.cz.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取构造器
 * @author Kartoffel
 * @create 2020-03-10-9:05
 */
public class ReflectionDemo01 {
    public static void main(String[] args) throws Exception {
        /*
        获取构造方法
            * Constructor<?>[] gerConstructors()
            * Constructor<T> gerConstructors(类<?>... parameterType)

            * Constructor<T> gerDeclaredConstructors(类<?>... parameterType)
            * Constructor<?>[] gerDeclaredConstructors()
         */
        Class personClass = Person.class;
        Person p = new Person();

        // 1.Constructor<?>[] gerConstructors()
        Constructor[] constructors = personClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("--------------------------------------");

        // 2.Constructor<T> getConstructors(类<?>... parameterType)
        Constructor constructor = personClass.getConstructor(int.class, String.class);
        System.out.println(constructor);
        //调用构造函数newInstance(Object --- Initargs);
        Object  o = constructor.newInstance(18, "陈卓");
        System.out.println(o);

        //调用空构造函数
        Object o1 = personClass.newInstance();
        System.out.println(o1);
    }
}
