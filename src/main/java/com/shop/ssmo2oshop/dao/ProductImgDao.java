package com.shop.ssmo2oshop.dao;

import java.util.List;

import com.shop.ssmo2oshop.entity.ProductImg;

public interface ProductImgDao {
	
	List<ProductImg> queryProductImgList(long prductId);
	
	// 批量添加商品详情图片
	int batchInsertProductImg(List<ProductImg> productImgList);
	
	// 删除指定商品下的所有详情图
	int deleteProductImgByProductId(long productId);
}
