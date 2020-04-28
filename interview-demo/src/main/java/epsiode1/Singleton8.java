package epsiode1;

/**
 * 懒汉式 线程同步写法2 同步代码块+双检锁
 * 解决效率低和多线程中指令重排
 *
 * @author: zhangzichen
 * @date: 2020/4/28 13:46
 */
public class Singleton8 {
    private static volatile Singleton8 instance = null;

    private Singleton8(){}

    public static Singleton8 getInstance(){
        if(instance == null){
            synchronized(Singleton8.class){
                if(instance == null){
                    instance = new Singleton8();
                }
            }
        }
        return instance;
    }
}
