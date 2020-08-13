package com.shop.ssmo2oshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ssmo2oshop.dao.ProductCategoryDao;
import com.shop.ssmo2oshop.entity.ProductCategory;
import com.shop.ssmo2oshop.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Override
	public List<ProductCategory> getProductCategoryList(long shopId){
		return productCategoryDao.queryProductCategoryList(shopId);
	}
}
