package com.shop.ssmo2oshop.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="shopadmin", method=RequestMethod.GET)
public class ShopAdminController {
	@RequestMapping(value="/shopoperation")
	public String shopOperation() {
		return "shop/shopoperation";
	}
	
	@RequestMapping(value="/shoplist")
	public String shopList() {
		return "shop/shoplist";
	}
	
	@RequestMapping(value="/shopmanagement")
	public String shopManagement() {
		return "shop/shopmanagement";
	}
	
	@RequestMapping(value="/productcategorymanagement")
	public String productCategoryManagement() {
		return "shop/productcategorymanagement";
	}
	
	@RequestMapping(value = "/productoperation")
	public String productOperation() {
		// 转发至商品添加/编辑页面
		return "shop/productoperation";
	}
	
	@RequestMapping(value = "/productmanagement")
	public String productManagement() {
		// 转发至商品管理页面
		return "shop/productmanagement";
	}
	
	
	
}