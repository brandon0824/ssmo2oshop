package com.shop.ssmo2oshop.service;

import java.util.List;

import com.shop.ssmo2oshop.dto.ImageHolder;
import com.shop.ssmo2oshop.dto.ProductExecution;
import com.shop.ssmo2oshop.entity.Product;
import com.shop.ssmo2oshop.exceptions.ProductOperationException;

public interface ProductService {
	
	// 添加商品以及图片处理
	ProductExecution addProduct(Product product,ImageHolder thumbnail, 
			List<ImageHolder> productImgList) 
			throws ProductOperationException;
	
	// 查询商品列表并分页，可输入的条件有： 商品名（模糊），商品状态，店铺Id,商品类别
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
	
	// 通过商品Id查询唯一的商品信息
	Product getProductById(long productId);
	
	// 修改商品信息以及图片处理
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException;
	
	
	
}
