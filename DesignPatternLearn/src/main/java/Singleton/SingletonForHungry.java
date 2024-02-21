package Singleton;

/**
 * @Description: 饿汉式（立即加载）
 * @Author zhengqiang
 * @Date 2024/2/20
 */
public class SingletonForHungry {

    //私有化构造函数（保证通过反射自己创建，不会被其他类new创建）
    private SingletonForHungry() {
    }

    //将自己实例化对象设置成一个属性，并用static.final修饰
    private static final SingletonForHungry instance = new SingletonForHungry();

    //static静态方法返回改实例
    public static SingletonForHungry getInstance(){
        return instance;
    }

}
