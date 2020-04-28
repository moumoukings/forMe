package epsiode1.test;

import epsiode1.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zhangzichen
 * @date 2020/04/28 13:31
 */
public class Singleton4Test {
    @Test
    public void test1() throws IOException {
        //非多线程demo
        /*Singleton4 s1 = Singleton4.getInstance();
        Singleton4 s2 = Singleton4.getInstance();
        System.out.println((s1 == s2));*/

        //多线程demo  线程不安全，有会产生两个对象的风险
        for (int i = 0; i < 100; i++) {
            new Thread(
                    new Runnable() {
                        public void run() {
                            System.out.println(Singleton4.getInstance());
                        }
                    }
            ).start();
        }
    }


    //同步方法，保证线程安全，效率低
    @Test
    public void test2() {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Singleton5.getInstance());
                }
            }
            ).start();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //加上同步代码块，保证线程安全,效率低
    @Test
    public void test3() {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Singleton6.getInstance());
                }
            }
            ).start();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //解决效率低，双检锁，但在多线程中存在指令重排风险
    @Test
    public void test4() {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Singleton7.getInstance());
                }
            }).start();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //解决效率低，双检锁，多线程中指令重排风险
    @Test
    public void test5() {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Singleton8.getInstance());
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