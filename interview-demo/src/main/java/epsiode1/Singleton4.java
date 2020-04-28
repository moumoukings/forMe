package epsiode1;

/**
 * 懒汉式
 * 最基础的懒汉式
 * @author zhangzichen
 * @date 2020/04/28 10:07
 */
public class Singleton4 {
    private static Singleton4 instance = null;

    private Singleton4(){}

    public static Singleton4 getInstance(){
        if(instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}
