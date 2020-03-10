package cn.cz.annotation;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试框架
 *
 * @author Kartoffel
 * @create 2020-03-10-12:11
 */
public class CalculateTest {
    public static void main(String[] args) throws IOException {

        // 1.创建对象
        Calculate calculate = new Calculate();
        // 2.获取字节码文件对象
        Class clazz = calculate.getClass();

        int number = 0;   // 接收异常次数
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bug.txt"));

        // 3.获取所有方法
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            // 4.判断方法是否被注解修饰
            if (method.isAnnotationPresent(Check.class)) {
                // 5.有,执行
                try {
                    method.invoke(calculate);
                } catch (Exception e) {
                    // 6.捕获异常
                    number++;
                    bufferedWriter.write(method.getName() + " 出现异常");
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常的名称 : " + e.getCause().getClass().getSimpleName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常的原因 : " + e.getCause().getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.write("--------------------------------------");
                    bufferedWriter.flush();
                    bufferedWriter.newLine();
                }
            }
        }

        bufferedWriter.write("异常出现 " + number + " 次");

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
