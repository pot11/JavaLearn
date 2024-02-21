package Singleton;
//懒汉式 双重锁定
public class SingletonForlazy {
    //将自己实例化对象设置成一个属性，并用static修饰
    private volatile static SingletonForlazy instance;

    public SingletonForlazy getInstance(){
        if (instance != null){
            //synchronized保证线程安全
            synchronized (SingletonForlazy.class){
                instance = new SingletonForlazy();
            }
        }
        return instance;
    }
}
