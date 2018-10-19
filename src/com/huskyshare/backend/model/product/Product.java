package com.huskyshare.backend.model.product;

import java.sql.Timestamp;
import java.util.Date;

public class Product {
    private Integer id;
    private String name;
    private String description;
    private Timestamp createTime;
    private Double marketPrice;
    private Double sellPrice;
    private Integer quantity;
    private Boolean inStock;
    private Integer categoryID;
    private Integer sellerID;

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
