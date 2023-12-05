package p19;

/**
 * @Description:
 * @Author zhengqiang
 * @Date 2023/11/10
 */
public class ImpOrderVO {
    private Long id;
    private Double OrderGroupNo;
    private String orderServiceCode;
    private String externalMedicine;//路径外用药

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderServiceCode() {
        return orderServiceCode;
    }

    public void setOrderServiceCode(String orderServiceCode) {
        this.orderServiceCode = orderServiceCode;
    }

    public Double getOrderGroupNo() {
        return OrderGroupNo;
    }

    public void setOrderGroupNo(Double orderGroupNo) {
        OrderGroupNo = orderGroupNo;
    }

    public String getExternalMedicine() {
        return externalMedicine;
    }

    public void setExternalMedicine(String externalMedicine) {
        this.externalMedicine = externalMedicine;
    }
}
