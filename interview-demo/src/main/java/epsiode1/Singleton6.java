package epsiode1;

/**
 * 懒汉式 线程同步写法2 同步代码块
 *
 * @author: zhangzichen
 * @date: 2020/4/28 13:46
 */
public class Singleton6 {
    private static Singleton6 instance = null;

    private Singleton6(){}

    public static Singleton6 getInstance(){
        synchronized(Singleton6.class){
            if(instance == null){
                instance = new Singleton6();
            }
        }
        return instance;
    }
}
