package epsiode1;

import java.io.Serializable;

/**
 * 单例模式：饿汉式
 *
 * @author zhangzichen
 * @date 2020/04/19 13:52
 */
public class Singleton1 implements Serializable {
    private static final long serialVersionUID = -4638138380395746983L;
    //持有该类属性
    private static Singleton1 instance = new Singleton1();
    //私有构造器
    private Singleton1(){

    }
    //对外提供获取实例的静态方法
    public static Singleton1 getInstance(){
        return instance;
    }

//    public Object readResolve(){
//        return instance;
//    }
}