package p19;

/**
 * @Description:
 * @Author zhengqiang
 * @Date 2023/11/10
 */
public class CPPatOrderVO {
    private Long orderId;
    private Double groupNo;
    private String orderServiceCode;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(Double groupNo) {
        this.groupNo = groupNo;
    }

    public String getOrderServiceCode() {
        return orderServiceCode;
    }

    public void setOrderServiceCode(String orderServiceCode) {
        this.orderServiceCode = orderServiceCode;
    }
}
