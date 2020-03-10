package cn.cz.annotation;

import java.lang.annotation.Target;

/**
 * @author Kartoffel
 * @create 2020-03-10-12:04
 */
public class Calculate {

    @Check
    public void add() {
        String n = null;
        n.toString();
        System.out.printf("%d + %d = %d\n", 3, 2, 3 + 2);
    }
    @Check
    public void sub() {
        System.out.printf("%d - %d = %d\n", 3, 1, 3 - 1);
    }
    @Check
    public void mul() {
        System.out.printf("%d * %d = %d\n", 3, 10, 3 * 10);
    }
    @Check
    public void div() {
        System.out.printf("%d / %d = %d\n", 3, 0, 3 / 0);
    }
}
