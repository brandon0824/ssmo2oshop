package com.shop.ssmo2oshop.dao;

import java.util.List;

import com.shop.ssmo2oshop.entity.Area;

public interface AreaDao {
	/*
	 返回区域列表
	@return areaList
	*/
	List<Area> queryArea();
}
