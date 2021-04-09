package epsiode1;

/**
 * 登记式
 *
 * @author zhangzichen
 * @date 2020/04/24 0:00
 */
public class Singleton2 {
    /**
     * 静态内部类
     */
    private static class SingletonHolder{
        private static Singleton2 instance = new Singleton2();
    }

    private Singleton2(){
        System.out.println("singleton2 load...");
    }

    public static Singleton2 getInstance(){
        return SingletonHolder.instance;
    }

    //用于解决禁止反射问题
    public Object readResolve(){
        return SingletonHolder.instance;
    }
}
