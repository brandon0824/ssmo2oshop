package com.shop.ssmo2oshop.dao;

import java.util.List;

import com.shop.ssmo2oshop.entity.ProductCategory;

public interface ProductCategoryDao {
	
	// 通过shopId查询店铺类别
	List<ProductCategory> queryProductCategoryList(long shopId);
	
	// 批量新增商品类别
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);
	
}
