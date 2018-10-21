package com.huskyshare.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "tb_product")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "product_id")
   private Integer id;

   @Column(name = "product_name", nullable = false, length = 64)
   private String productName;

   @JoinColumn(name = "user_id")//关联user表的字段
   @ManyToOne
   private User seller;

   @Column(name = "product_description", columnDefinition = "TEXT")
   private String description;

   @Column(name = "product_create_time")
   private Timestamp createTime;

   @Column(name = "product_market_price")
   private Double marketPrice;

   @Column(name = "product_sell_price")
   private Double sellPrice;

   @Column(name = "product_quantity")
   private Integer quantity;

   @JoinColumn(name = "category_id")
   @ManyToOne
   private Category category;

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

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public User getSeller() {
      return seller;
   }

   public void setSeller(User seller) {
      this.seller = seller;
   }
}
