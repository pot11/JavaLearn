package p1;
//懒汉式 双重锁定
public class SingletonForlazy {
    private volatile static SingletonForlazy instance;

    public SingletonForlazy getInstance(){
        if (instance != null){
            synchronized (SingletonForlazy.class){
                instance = new SingletonForlazy();
            }
        }
        return instance;
    }
}
