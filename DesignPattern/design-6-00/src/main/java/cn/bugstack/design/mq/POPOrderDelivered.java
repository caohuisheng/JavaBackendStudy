package cn.bugstack.design.mq;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Author: chs
 * Description: 外部订单消息
 * CreateTime: 2024-10-07
 */
public class POPOrderDelivered {

    private String uId;       //用户id
    private String orderId;   //订单id
    private String sku;       //下单时间
    private String skuName;   //商品
    private BigDecimal price; //商品名称
    private Date orderTime;   //金额

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
