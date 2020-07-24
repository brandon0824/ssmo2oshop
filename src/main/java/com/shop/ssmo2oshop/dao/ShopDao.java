package com.shop.ssmo2oshop.dao;

import com.shop.ssmo2oshop.entity.Shop;

public interface ShopDao {
	//新增店铺 返回1 新增成功
	int insertShop(Shop shop);
	
	//更新店铺信息
	int updateShop(Shop shop);
}
