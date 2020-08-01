package com.shop.ssmo2oshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.ssmo2oshop.entity.ShopCategory;

public interface ShopCategoryDao {
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondtion);
}
