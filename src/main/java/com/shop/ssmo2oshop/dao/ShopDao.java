package com.shop.ssmo2oshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.ssmo2oshop.entity.Shop;

public interface ShopDao {
	
	// 通过shop id查询店铺
	Shop queryByShopId(long shopId);
	
	//新增店铺 返回1 新增成功
	int insertShop(Shop shop);
	
	//更新店铺信息
	int updateShop(Shop shop);
	
	// 分页查询店铺 可输入的条件有：店铺名(模糊) 店铺状态 店铺类别 区域Id owner
	// 从第rowIndex行去取 一共取pageSize行
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,
			@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
	
	// 返回queryShopList总数
	int queryShopCount(@Param("shopCondition") Shop shopCondition);
}







