package com.shop.ssmo2oshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ssmo2oshop.dao.ShopCategoryDao;
import com.shop.ssmo2oshop.entity.ShopCategory;
import com.shop.ssmo2oshop.service.ShopCategoryService;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService{
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition){
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}
}
