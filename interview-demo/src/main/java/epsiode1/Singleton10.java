package epsiode1;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 单例模式的CAS方式 利用Java的原子性
 *
 * @author zhangzichen
 * @date 2020/04/28 14:10
 */
public class Singleton10 {

    private static final AtomicReference<Singleton10> instance = new AtomicReference<Singleton10>();

    private Singleton10(){
        System.out.println("Singlenton10 Loaded");
    }

    public static final Singleton10 getInstance(){
        while (true){
            Singleton10 current = instance.get();
            if(current != null){
                return current;
            }
            current = new Singleton10();
            if(instance.compareAndSet(null,current)){
                return current;
            }
        }
    }

}
