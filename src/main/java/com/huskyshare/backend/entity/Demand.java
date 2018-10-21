package com.huskyshare.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "tb_demand")
public class Demand {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "demand_id")
   private Integer id;

   @Column(name = "demand_name", nullable = false, length = 64)
   private String demandName;

   @JoinColumn(name = "user_id")//关联user表的字段
   @ManyToOne
   private User seller;

   @Column(name = "demand_description", columnDefinition = "TEXT")
   private String description;

   @Column(name = "demand_create_time")
   private Timestamp createTime;

   @Column(name = "demand_quantity")
   private Integer quantity;

   @Column(name = "category_name")
   private String category;

   @Column(name="img_path")
   private String imgPath;


   public String getImgPath() {
      return imgPath;
   }

   public void setImgPath(String imgPath) {
      this.imgPath = imgPath;
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

   public Integer getQuantity() {
      return quantity;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getDemandName() {
      return demandName;
   }

   public void setDemandName(String demandName) {
      this.demandName = demandName;
   }

   public User getSeller() {
      return seller;
   }

   public void setSeller(User seller) {
      this.seller = seller;
   }
}
