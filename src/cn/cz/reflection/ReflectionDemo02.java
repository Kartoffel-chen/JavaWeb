package cn.cz.reflection;

import cn.cz.domain.Person;

import java.lang.reflect.Method;

/**
 * @author Kartoffel
 * @create 2020-03-10-9:16
 */
public class ReflectionDemo02 {
    public static void main(String[] args) throws Exception {
        /*
        获取成员方法
            * Method[] getMethods()
            * Method getMethod(String name,类<?>... parameterType)

            * Method[] getDeclaredMethods()
            * Method getDeclaredMethod(String name,类<?>... parameterType)
         */

        Class personClass = Person.class;

        // 1.Method[] getMethods()
        Method[] methods = personClass.getMethods();

        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("------------------------- ");

        // 2.Method getMethod(String name,类<?>... parameterType)
        Method eat_Method = personClass.getMethod("eat");
        Person p = new Person();
        eat_Method.invoke(p);

        // 3.Method getDeclaredMethod(String name,类<?>... parameterType)
        Method eat_Method1 = personClass.getDeclaredMethod("eat", String.class);
        eat_Method1.setAccessible(true);
        eat_Method1.invoke(p,"饭");

        String name = personClass.getName();
        System.out.println(name);

    }
}
