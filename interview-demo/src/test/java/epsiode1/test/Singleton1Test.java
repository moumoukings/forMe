package epsiode1.test;

import epsiode1.Singleton1;
import org.junit.Test;

/**
 * 饿汉式
 *
 * @author zhangzichen
 * @date 2020/04/19 14:01
 */
public class Singleton1Test {

    @Test
    public void test() {
       Singleton1 s1 = Singleton1.getInstance();
       Singleton1 s2 = Singleton1.getInstance();
        System.out.println(s1 == s2);
    }

    @Test
    public void test2(){
        for (int i = 0; i < 20; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                public void run() {
                    System.out.println( finalI +"====="+ Singleton1.getInstance());
                }
            }).start();
        }
    }

}