package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: JDK动态代理
 * @Author zhengqiang
 * @Date 2024/2/21
 */
public class JdkProxy {
    public static void main(String[] args) {
        //委托对象
        IRentHouse rentingHouse = new RentHouseImpl();
        //获取代理对象 参数（委托对象的类加载器，委托对象实现的接口，InvocationHandler接口实现类--方法增强逻辑）
        IRentHouse proxyInstance = (IRentHouse)Proxy.newProxyInstance(rentingHouse.getClass().getClassLoader(), rentingHouse.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("收取中介费300元");
                //原有业务逻辑 参数（委托类对象实例，方法参数）
                method.invoke(rentingHouse, args);
                System.out.println("买到客户信息赚3毛");
                return null;
            }
        });
        proxyInstance.rentHouse();
        proxyInstance.study();

        //从代理对象工厂获取代理对象
        IRentHouse jdkProxy = (IRentHouse)JDKProxyFactory.getInstance().getJdkProxy(rentingHouse);
        jdkProxy.rentHouse();
        jdkProxy.study();


    }
}
