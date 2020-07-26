package com.shop.ssmo2oshop.service;

import java.io.File;

import com.shop.ssmo2oshop.dto.ShopExecution;
import com.shop.ssmo2oshop.entity.Shop;

public interface ShopService {
	ShopExecution addShop(Shop shop, File ShopImg);
	
}
