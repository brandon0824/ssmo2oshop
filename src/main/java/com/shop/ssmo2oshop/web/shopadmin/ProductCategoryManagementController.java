package com.shop.ssmo2oshop.web.shopadmin;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.shop.ssmo2oshop.dto.ProductCategoryExecution;
import com.shop.ssmo2oshop.dto.Result;
import com.shop.ssmo2oshop.entity.ProductCategory;
import com.shop.ssmo2oshop.entity.Shop;
import com.shop.ssmo2oshop.enums.ProductCategoryStateEnum;
//import com.shop.ssmo2oshop.exceptions.ProductCategoryOperationException;
import com.shop.ssmo2oshop.service.ProductCategoryService;

@Controller
@RequestMapping("/shopadmin")
public class ProductCategoryManagementController {
	@Autowired
	private ProductCategoryService productCategoryService;

	@RequestMapping(value = "/getproductcategorylist", method = RequestMethod.GET)
	@ResponseBody
	private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request) {

		Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
		List<ProductCategory> list = null;
		
		if (currentShop != null && currentShop.getShopId() > 0) {
			list = productCategoryService.getProductCategoryList(currentShop.getShopId());
			return new Result<List<ProductCategory>>(true, list);
		} else {
			ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
			return new Result<List<ProductCategory>>(false, ps.getState(), ps.getStateInfo());
		}
	}

}