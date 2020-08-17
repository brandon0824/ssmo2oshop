package com.shop.ssmo2oshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.ssmo2oshop.entity.HeadLine;

public interface HeadLineDao {

	// 根据传入的查询条件(头条名查询头条)
	List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);

	// 根据头条id返回唯一的头条信息
	HeadLine queryHeadLineById(long lineId);

	// 根据传入的Id列表查询头条信息(供超级管理员选定删除头条的时候用，主要是处理图片)
	List<HeadLine> queryHeadLineByIds(List<Long> lineIdList);

	// 插入头条
	int insertHeadLine(HeadLine headLine);

	// 更新头条信息
	int updateHeadLine(HeadLine headLine);

	// 删除头条
	int deleteHeadLine(long headLineId);

	// lineIdList
	int batchDeleteHeadLine(List<Long> lineIdList);
}
