package com.shop.ssmo2oshop.service;

import java.io.InputStream;

import com.shop.ssmo2oshop.dto.ShopExecution;
import com.shop.ssmo2oshop.entity.Shop;
import com.shop.ssmo2oshop.exceptions.ShopOperationException;

public interface ShopService {
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
	
}
