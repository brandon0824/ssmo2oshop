package com.shop.ssmo2oshop.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.shop.ssmo2oshop.dao.ShopDao;
import com.shop.ssmo2oshop.dto.ShopExecution;
import com.shop.ssmo2oshop.entity.Shop;
import com.shop.ssmo2oshop.enums.ShopStateEnum;
import com.shop.ssmo2oshop.service.ShopService;

public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao shopDao;

	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, File ShopImg) {
		if(shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int effectedNum = shopDao.insertShop(shop);
			
			
			
			
		}catch(Exception e) {
			throw new RuntimeException("addShop error:" + e.getMessage());
		}
		return null;
	}
	
}
