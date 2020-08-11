package com.shop.ssmo2oshop.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shop.ssmo2oshop.BaseTest;
import com.shop.ssmo2oshop.entity.Area;
import com.shop.ssmo2oshop.entity.PersonInfo;
import com.shop.ssmo2oshop.entity.Shop;
import com.shop.ssmo2oshop.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;

	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试店铺名字");
		shop.setShopDesc("desc");
		shop.setShopAddr("addr");
		shop.setPhone("phone");
		shop.setShopImg("imgtest");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
	
	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);

	}
	
	@Test
	@Ignore
	public void testQueryByShopId() {
		long shopId = 1;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println("areaId:" + shop.getArea().getAreaId());
		System.out.println("areaName:" + shop.getArea().getAreaName());
	}
	
	@Test
	public void testQueryShopListAndCount() {
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 3);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("owner_id=1的List中店铺列表数量：" + shopList.size());
		System.out.println("owner_id=1店铺总数：" + count);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(3L);
		shopCondition.setShopCategory(sc);
		shopList = shopDao.queryShopList(shopCondition, 0, 1);
		System.out.println("owner_id=1,shopCategoryId=3的List中店铺列表的大小：" + shopList.size());
		count = shopDao.queryShopCount(shopCondition);
		System.out.println("owner_id=1,shopCategoryId=3店铺总数：" + count);
		
	}
	
	
	
	
	
}
