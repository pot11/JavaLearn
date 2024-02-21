package proxy.staticProxy;

/**
 * @Description: 静态代理
 * @Author zhengqiang
 * @Date 2024/2/21
 */
public class Test {
    public static void main(String[] args) {
        //自己租房
        RentHouseImpl rentHouse = new RentHouseImpl();
        rentHouse.rentHouse();

        //静态代理
        RentHouseProxy rentHouseProxy = new RentHouseProxy(rentHouse);
        rentHouseProxy.rentHouse();

    }


}
