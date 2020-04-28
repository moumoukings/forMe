package epsiode1;

/**
 * 懒汉式 线程同步写法1 同步方法
 *
 * @author: zhangzichen
 * @date: 2020/4/28 13:46
 */
public class Singleton5 {
    private static Singleton5 instance = null;

    private Singleton5(){}

    public static synchronized Singleton5 getInstance(){
        if(instance == null){
            instance = new Singleton5();
        }
        return instance;
    }
}
