package com.shop.ssmo2oshop.service;

import java.util.List;

import com.shop.ssmo2oshop.entity.ShopCategory;

public interface ShopCategoryService {
	
	// 根据查询条件获取ShopCategory列表
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
