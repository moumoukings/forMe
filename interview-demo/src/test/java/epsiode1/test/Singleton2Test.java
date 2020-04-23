package epsiode1.test;

import epsiode1.Singleton2;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 登记类测试
 *
 * @author zhangzichen
 * @date 2020/04/24 0:05
 */
public class Singleton2Test {

    @Test
    public void test1(){
        /*Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1 == s2);*/
        try {
            Class.forName("epsiode1.Singleton2");
            Singleton2.getInstance(); //在调用get方法时才创建对象，实现延迟加载
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 禁止反射，保证防御反射的攻击
     * 解决方法：在类中加上readResolve方法
     */
    @Test
    public void test2() throws Exception {
        Class<Singleton2> clazz = Singleton2.class;
        Constructor<Singleton2> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = constructor.newInstance();
        System.out.println(s1 == s2);

    }
}
