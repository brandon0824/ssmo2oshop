package com.shop.ssmo2oshop.dto;

import java.util.List;

import com.shop.ssmo2oshop.entity.ProductCategory;
import com.shop.ssmo2oshop.enums.ProductCategoryStateEnum;

public class ProductCategoryExecution {
	// 结果状态
	private int state;
	
	// 状态标识
	private String stateInfo;
	
	private List<ProductCategory> productCategoryList;
	
	public ProductCategoryExecution() {
		
	}
	
	// 操作失败时使用的构造器
	public ProductCategoryExecution(ProductCategoryStateEnum stateEnum) {
		this.state = state;
		this.stateInfo = stateEnum.getStateInfo();
	}
	
	// 操作成功时使用的构造器
	public ProductCategoryExecution(ProductCategoryStateEnum stateEnum, List<ProductCategory> productCategoryList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.productCategoryList = productCategoryList;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateIndo) {
		this.stateInfo = stateIndo;
	}

	public List<ProductCategory> getProductCategoryList() {
		return productCategoryList;
	}

	public void setProductCategoryList(List<ProductCategory> productCategoryList) {
		this.productCategoryList = productCategoryList;
	}
	
	
}





