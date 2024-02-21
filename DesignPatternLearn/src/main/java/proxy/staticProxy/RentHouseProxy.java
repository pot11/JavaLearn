package proxy.staticProxy;

/**
 * @Description: 代理对象
 * @Author zhengqiang
 * @Date 2024/2/21
 */
public class RentHouseProxy implements IRentHouse{
    private RentHouseImpl rentHouse;

    public RentHouseProxy(RentHouseImpl rentHouse) {
        this.rentHouse = rentHouse;
    }

    /**
     * 1.实现委托对象的相同接口
     * 2.增强逻辑
     * 3.调用原委托对象逻辑
     * 4.增强逻辑
     */
    @Override
    public void rentHouse() {
        System.out.println("收取中介费300元");
        rentHouse.rentHouse();
        System.out.println("买到客户信息赚3毛");
    }
}
