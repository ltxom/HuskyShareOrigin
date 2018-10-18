package com.huskyshare.beans;

import java.sql.Timestamp;
import java.util.Date;

public class ProductInfo {
	private int id;
	private String name;
	private String description;
	private Timestamp createTime;
	private float basePrice;
	private float marketPrice;
	private float sellPrice;
	private String sexrequest;
	private boolean commend;
	private int clickCount;
	private int sellCount;
	private int categoryId;
	private int uploadFile;
	private ProductCategory category;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the basePrice
	 */
	public float getBasePrice() {
		return basePrice;
	}
	/**
	 * @param basePrice the basePrice to set
	 */
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	/**
	 * @return the marketPrice
	 */
	public float getMarketPrice() {
		return marketPrice;
	}
	/**
	 * @param marketPrice the marketPrice to set
	 */
	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}
	/**
	 * @return the sellPrice
	 */
	public float getSellPrice() {
		return sellPrice;
	}
	/**
	 * @param sellPrice the sellPrice to set
	 */
	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}
	/**
	 * @return the sexrequest
	 */
	public String getSexrequest() {
		return sexrequest;
	}
	/**
	 * @param sexrequest the sexrequest to set
	 */
	public void setSexrequest(String sexrequest) {
		this.sexrequest = sexrequest;
	}
	/**
	 * @return the commend
	 */
	public boolean isCommend() {
		return commend;
	}
	/**
	 * @param commend the commend to set
	 */
	public void setCommend(boolean commend) {
		this.commend = commend;
	}
	/**
	 * @return the clickCount
	 */
	public int getClickCount() {
		return clickCount;
	}
	/**
	 * @param clickCount the clickCount to set
	 */
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	/**
	 * @return the sellCount
	 */
	public int getSellCount() {
		return sellCount;
	}
	/**
	 * @param sellCount the sellCount to set
	 */
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the uploadFile
	 */
	public int getUploadFile() {
		return uploadFile;
	}
	/**
	 * @param uploadFile the uploadFile to set
	 */
	public void setUploadFile(int uploadFile) {
		this.uploadFile = uploadFile;
	}
	/**
	 * @return the category
	 */
	public ProductCategory getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
}
