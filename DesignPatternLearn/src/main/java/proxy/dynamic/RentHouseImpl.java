package proxy.dynamic;

import proxy.dynamic.IRentHouse;

/**
 * @Description: 委托对象
 * @Author zhengqiang
 * @Date 2024/2/21
 */
public class RentHouseImpl implements IRentHouse {
    @Override
    public void rentHouse() {
        System.out.println("我想租一室一厅");
    }

    @Override
    public void study() {
        System.out.println("我想找个学习的房子");
    }
}
