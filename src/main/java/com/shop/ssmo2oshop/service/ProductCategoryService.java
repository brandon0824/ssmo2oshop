package com.shop.ssmo2oshop.service;

import java.util.List;

import com.shop.ssmo2oshop.dto.ProductCategoryExecution;
import com.shop.ssmo2oshop.entity.ProductCategory;
import com.shop.ssmo2oshop.exceptions.ProductCategoryOperationException;

public interface ProductCategoryService {

	// 查询指定某个店铺下的所有商品类别信息
	List<ProductCategory> getProductCategoryList(long shopId);
	
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
	
	// 将此类别下的商品里的类别id置为空，再删除掉该商品类别
	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException;
}
