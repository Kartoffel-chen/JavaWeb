package cn.cz.test;

import cn.cz.junit.Calculate;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kartoffel
 * @create 2020-03-09-20:39
 */
public class CalculateTest {

    @Test
    public void testAdd() {
        Calculate c = new Calculate();
        int res = c.add(1, 3);
        Assert.assertEquals(4, res);
    }
}