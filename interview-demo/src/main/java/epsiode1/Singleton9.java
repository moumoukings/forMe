package epsiode1;

/**
 * 单例模式的ThreadLocal方式
 *
 * @author zhangzichen
 * @date 2020/04/28 14:10
 */
public class Singleton9 {

    private static Singleton9 instance = new Singleton9();

    private Singleton9(){}

    private static final ThreadLocal<Singleton9> threadLocal = new ThreadLocal<Singleton9>(){
        @Override
        protected Singleton9 initialValue() {
            return new Singleton9();
        }
    };

    public static Singleton9 getInstance(){
        return threadLocal.get();
    }

}
