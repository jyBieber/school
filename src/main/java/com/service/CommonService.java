package com.service;

import java.util.List;
import java.util.Map;

public interface CommonService {
	List<String> getOption(Map<String, Object> params);
	
	Map<String, Object> getFollowByOption(Map<String, Object> params);
	
	void sh(Map<String, Object> params);
	
	int remindCount(Map<String, Object> params);
	
	Map<String, Object> selectCal(Map<String, Object> params);

	List<Map<String, Object>> chartBoth(Map<String, Object> params);

	List<Map<String, Object>> chartOne(Map<String, Object> params);

	List<Map<String, Object>> selectGroup(Map<String, Object> params);
	
	List<Map<String, Object>> selectValue(Map<String, Object> params);

	/**
	 tableName 查询表
	 condition1 条件1
	 condition1Value 条件1值
	 average 计算平均评分
	 * */
	Map<String, Object> queryScore(Map<String, Object> params);

	/**
	 * 新的级联字典表的  分组求和统计
	 */
	List<Map<String, Object>> newSelectGroupSum(Map<String, Object> params);

	/**
	 * 新的级联字典表的  分组求和统计
	 */
	List<Map<String, Object>> newSelectGroupCount(Map<String, Object> params);
	/**
	 * 当前表的日期分组求和
	 */
	List<Map<String, Object>> newSelectDateGroupSum(Map<String, Object> params);

	/**
	 * 查询字典表的分组统计总条数
	 */
	List<Map<String, Object>> newSelectDateGroupCount(Map<String, Object> params);
	/**
	 * 增加字段数字
	 */
	int plusCloumNumber(Map<String, Object> params);
	/**
	 * 减少字段数字
	 */
	int reduceCloumNumber(Map<String, Object> params);
	/**
	 * 修改字段数字
	 */
	int updateCloumValue(Map<String, Object> params);

	/**
	 * 柱状图求和
	 */
	List<Map<String, Object>> barSum(Map<String, Object> params);
	/**
	 * 柱状图统计
	 */
	List<Map<String, Object>> barCount(Map<String, Object> params);

}