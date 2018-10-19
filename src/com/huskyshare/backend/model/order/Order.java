package com.huskyshare.backend.model.order;

import com.huskyshare.backend.model.user.DormAddress;

import java.sql.Timestamp;

public class Order {
    private String id;
    private Integer addressId;
    private Timestamp createTime;
    private String orderState;
    private Integer customerId;
    private Integer sellerId;
    private Integer productId;
    private Boolean customerHasConfirmed;
    private Boolean sellerHasConfirmed;

    public Boolean getCustomerHasConfirmed() {
        return customerHasConfirmed;
    }

    public void setCustomerHasConfirmed(Boolean customerHasConfirmed) {
        this.customerHasConfirmed = customerHasConfirmed;
    }

    public Boolean getSellerHasConfirmed() {
        return sellerHasConfirmed;
    }

    public void setSellerHasConfirmed(Boolean sellerHasConfirmed) {
        this.sellerHasConfirmed = sellerHasConfirmed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
