package cn.gov.zjport.entity;

public class VipRankEntity {
        private int code;
        private String name;
        private String remark;
        private int needAmount;
        private int discount;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getNeedAmount() {
        return needAmount;
    }

    public void setNeedAmount(int needAmount) {
        this.needAmount = needAmount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
