package com.shop.ssmo2oshop.service;

import java.util.List;

import com.shop.ssmo2oshop.entity.ProductCategory;

public interface ProductCategoryService {

	// 查询指定某个店铺下的所有商品类别信息
	List<ProductCategory> getProductCategoryList(long shopId);
	
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
	
}
