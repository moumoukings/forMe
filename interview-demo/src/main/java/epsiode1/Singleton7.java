package epsiode1;

/**
 * 懒汉式 线程同步写法2 同步代码块+双检锁
 * 解决了效率低但是在多线程中会有指令重排的风险
 *
 * @author: zhangzichen
 * @date: 2020/4/28 13:46
 */
public class Singleton7 {
    private static Singleton7 instance = null;

    private Singleton7(){}

    public static Singleton7 getInstance(){
        if(instance == null){
            synchronized(Singleton7.class){
                if(instance == null){
                    instance = new Singleton7();
                }
            }
        }
        return instance;
    }
}
