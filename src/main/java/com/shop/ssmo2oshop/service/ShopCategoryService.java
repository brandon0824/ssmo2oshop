package com.shop.ssmo2oshop.service;

import java.util.List;

import com.shop.ssmo2oshop.entity.ShopCategory;

public interface ShopCategoryService {
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
