package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author zhengqiang
 * @Date 2024/2/21
 */
public class JDKProxyFactory {
    private JDKProxyFactory() {
    }

    private static JDKProxyFactory instance = new JDKProxyFactory();

    //static修饰
    public static JDKProxyFactory getInstance(){
        return instance;
    }

    /**
     *
     * @param obj 委托对象
     * @return 代理对象
     */
    public Object getJdkProxy(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("rentHouse".equals(method.getName())){
                    System.out.println("增强逻辑一室一厅前");
                    //
                    method.invoke(obj,args);
                    System.out.println("增强逻辑一室一厅后");
                }
                if ("study".equals(method.getName())){
                    System.out.println("增强逻辑学习前");
                    method.invoke(obj,args);
                    System.out.println("增强逻辑学习后");
                }
                return null;
            }
        });

    }
}
