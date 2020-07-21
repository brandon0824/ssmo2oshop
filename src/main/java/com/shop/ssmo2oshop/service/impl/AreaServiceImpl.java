package com.shop.ssmo2oshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ssmo2oshop.dao.AreaDao;
import com.shop.ssmo2oshop.entity.Area;
import com.shop.ssmo2oshop.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	private AreaDao areaDao;
	
	@Override
	public List<Area> getAreaList() {

		return areaDao.queryArea();
	}
	
}
