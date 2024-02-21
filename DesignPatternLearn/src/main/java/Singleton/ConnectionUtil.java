package Singleton;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description: 创建线程工具类（同一线程一个连接）
 * @Author zhengqiang
 * @Date 2024/2/21
 */
public class ConnectionUtil {
    //私有构造
    private static final ConnectionUtil instance = new ConnectionUtil();
    private ConnectionUtil() {
    }
    public static ConnectionUtil getInstance(){
        return instance;
    }

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();//存储当前线程的连接

    //从当前线程获取连接，如果没有绑定，需要从线程池中哦那个获取一个绑定当前到当前线程
    public Connection getCurrentThreadLocalConn() throws SQLException{
        Connection connection =  threadLocal.get();
        if(connection == null){
//            Connection connection = DruidUtils.getinstance().getconnection();//伪代码
            threadLocal.set(connection);
        }
        return connection;
    }
}
