package com.shop.ssmo2oshop.service;

import java.util.List;

import com.shop.ssmo2oshop.dto.HeadLineExecution;
import com.shop.ssmo2oshop.dto.ImageHolder;
import com.shop.ssmo2oshop.entity.HeadLine;

public interface HeadLineService {
	public static final String HLLISTKEY = "headlinelist";

	// 根据传入的条件返回指定的头条列表
	List<HeadLine> getHeadLineList(HeadLine headLineCondition);

	// 添加头条信息，并存储头条图片
	HeadLineExecution addHeadLine(HeadLine headLine, ImageHolder thumbnail);

	// 修改头条信息
	HeadLineExecution modifyHeadLine(HeadLine headLine, ImageHolder thumbnail);

	// 删除单条头条
	HeadLineExecution removeHeadLine(long headLineId);

	// 批量删除头条
	HeadLineExecution removeHeadLineList(List<Long> headLineIdList);
}