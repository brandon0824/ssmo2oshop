package com.shop.ssmo2oshop.dto;

import java.util.List;

import com.shop.ssmo2oshop.entity.ProductCategory;
import com.shop.ssmo2oshop.entity.Shop;
import com.shop.ssmo2oshop.enums.ProductCategoryStateEnum;

public class ProductCategoryExecution {
	// 结果状态
	private int state;
	
	// 状态标识
	private String stateIndo;
	
	private List<ProductCategory> productCategoryList;
	
	public ProductCategoryExecution() {
		
	}
	
	// 操作失败时使用的构造器
	public ProductCategoryExecution(ProductCategoryStateEnum stateEnum) {
		this.state = state;
		this.stateIndo = stateEnum.getStateInfo();
	}
	
	// 操作成功时使用的构造器
	
}





