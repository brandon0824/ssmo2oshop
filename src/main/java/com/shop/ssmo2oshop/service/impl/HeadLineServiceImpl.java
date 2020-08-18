package com.shop.ssmo2oshop.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.ssmo2oshop.dao.HeadLineDao;
import com.shop.ssmo2oshop.dto.HeadLineExecution;
import com.shop.ssmo2oshop.dto.ImageHolder;
import com.shop.ssmo2oshop.entity.HeadLine;
import com.shop.ssmo2oshop.enums.HeadLineStateEnum;
import com.shop.ssmo2oshop.exceptions.HeadLineOperationException;
import com.shop.ssmo2oshop.service.HeadLineService;
import com.shop.ssmo2oshop.util.ImageUtil;
import com.shop.ssmo2oshop.util.PathUtil;

@Service
public class HeadLineServiceImpl implements HeadLineService {
	
	@Autowired
	private HeadLineDao headLineDao;
	
	@Override
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws HeadLineOperationException{
		return headLineDao.queryHeadLine(headLineCondition);
	}

	@Override
	public HeadLineExecution addHeadLine(HeadLine headLine, ImageHolder thumbnail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeadLineExecution modifyHeadLine(HeadLine headLine, ImageHolder thumbnail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeadLineExecution removeHeadLine(long headLineId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeadLineExecution removeHeadLineList(List<Long> headLineIdList) {
		// TODO Auto-generated method stub
		return null;
	}

}
