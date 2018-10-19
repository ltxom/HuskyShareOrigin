package com.huskyshare.backend.model.file;

public class ProductImg{
	private Integer id;
	private Integer productId;
	private Integer uploadFileId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getUploadFileId() {
		return uploadFileId;
	}

	public void setUploadFileId(Integer uploadFileId) {
		this.uploadFileId = uploadFileId;
	}
}
