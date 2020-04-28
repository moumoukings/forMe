package epsiode1.test;

import epsiode1.Singleton10;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author zhangzichen
 * @date 2020/04/28 14:42
 */
public class Singleton10Test {

    @Test
    public void test1() throws IOException {
        //多线程测试
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println("Singleton10.getInstance() = " + Singleton10.getInstance());
                }
            }).start();
        }
        System.in.read();
    }

    
}