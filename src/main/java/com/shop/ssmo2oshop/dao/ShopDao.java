package com.shop.ssmo2oshop.dao;

import com.shop.ssmo2oshop.entity.Shop;

public interface ShopDao {
	
	// 通过shop id查询店铺
	Shop queryByShopId(long shopId);
	
	//新增店铺 返回1 新增成功
	int insertShop(Shop shop);
	
	//更新店铺信息
	int updateShop(Shop shop);
}
