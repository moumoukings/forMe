package epsiode1.test;

import epsiode1.Singleton3;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author zhangzichen
 * @date 2020/04/24 1:09
 */
public class Singleton3Test {

    @Test
    public void test1() {
        Singleton3 s1 = Singleton3.INSTANCE;
        Singleton3 s2 = Singleton3.INSTANCE;
        System.out.println(s1 == s2);
    }

    /**
     * 防止了反射的攻击
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Class<Singleton3> clazz = Singleton3.class;
        Constructor<Singleton3> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton3 s1 = constructor.newInstance();
    }

    @Test
    public void test() {
        Singleton3 s1 = Singleton3.INSTANCE;
    }
    
}