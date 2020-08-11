package com.shop.ssmo2oshop.service;

import java.io.InputStream;

import com.shop.ssmo2oshop.dto.ShopExecution;
import com.shop.ssmo2oshop.entity.Shop;
import com.shop.ssmo2oshop.exceptions.ShopOperationException;

public interface ShopService {
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
	
	// 通过店铺id获取店铺信息
	Shop getByShopId(long shopId);
	
	// 更新店铺信息包括对图片的处理
	ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
	
	// 根据shopCondition分页返回相应店铺列表
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
	
}
