package com.shop.ssmo2oshop.web.shopadmin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request){
		// 1.接收并转化响应的参数 包括店铺信息和图片信息
		// 2.注册店铺
		// 3.返回结果
		
	}
}







