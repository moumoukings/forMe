package epsiode1.test;

import epsiode1.Singleton9;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zhangzichen
 * @date 2020/04/28 14:22
 */
public class Singleton9Test {

    @Test
    public void test1() {
        //单线程
        Singleton9 s1 = Singleton9.getInstance();
        Singleton9 s2 = Singleton9.getInstance();
        System.out.println((s1 == s2));
    }

    @Test
    public void test2() {
        //多线程,不能保证所有线程都是单例的，只能保证同一个线程中他是单例的
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Singleton9 s1 = Singleton9.getInstance();
                    Singleton9 s2 = Singleton9.getInstance();
                    System.out.println(Thread.currentThread().getName()+":"+(s1 == s2)+" "+s1);
                }
            }).start();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}