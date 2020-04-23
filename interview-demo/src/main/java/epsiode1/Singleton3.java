package epsiode1;

/**
 * 枚举式
 *
 * @author zhangzichen
 * @date 2020/04/24 0:33
 */
public enum Singleton3 {
    INSTANCE{
        @Override
        protected void doSomething() {
            super.doSomething();
        }
    };
    protected void doSomething(){}
}
