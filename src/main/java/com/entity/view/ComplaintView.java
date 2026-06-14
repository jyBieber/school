package com.entity.view;

import com.entity.ComplaintEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 投诉信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("complaint")
public class ComplaintView extends ComplaintEntity implements Serializable {
    private static final long serialVersionUID = 1L;
	//add
	private String taskName;
	private String taskUuidNumber;
	private String yonghuName;
	private String yonghuPhone;
	private String errandsName;
	private String errandsPhone;
	/**
	* 投诉类型的值
	*/
	private String complaintValue;
	/**
	* 投诉状态的值
	*/
	private String complaintYesnoValue;

	//级联表 orderreceiving
	/**
	 * 订单的任务
	 */
	private Integer orderreceivingTaskId;
	/**
	 * 订单信息 的 跑腿
	 */
	private Integer orderreceivingErrandsId;
	/**
	 * 订单状态
	 */
	private Integer orderreceivingStatusTypes;
	/**
	 * 订单状态的值
	 */
	private String orderreceivingStatusValue;

	public ComplaintView() {

	}

	public ComplaintView(ComplaintEntity complaintEntity) {
		try {
			BeanUtils.copyProperties(this, complaintEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//add
// 新增字段的getter/setter ================================
	public String getTaskName() {
	return taskName;
}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String  getTaskUuidNumber() {
		return taskUuidNumber;
	}

	public void setTaskUuidNumber(String taskUuidNumber) {
		this.taskUuidNumber = taskUuidNumber;
	}

	public String getYonghuName() {
		return yonghuName;
	}

	public void setYonghuName(String yonghuName) {
		this.yonghuName = yonghuName;
	}

	public String getYonghuPhone() {
		return yonghuPhone;
	}

	public void setYonghuPhone(String yonghuPhone) {
		this.yonghuPhone = yonghuPhone;
	}

	public String getErrandsName() {
		return errandsName;
	}

	public void setErrandsName(String errandsName) {
		this.errandsName = errandsName;
	}

	public String getErrandsPhone() {
		return errandsPhone;
	}

	public void setErrandsPhone(String errandsPhone) {
		this.errandsPhone = errandsPhone;
	}

	/**
	* 获取： 投诉类型的值
	*/
	public String getComplaintValue() {
		return complaintValue;
	}
	/**
	* 设置： 投诉类型的值
	*/
	public void setComplaintValue(String complaintValue) {
		this.complaintValue = complaintValue;
	}
	/**
	* 获取： 投诉状态的值
	*/
	public String getComplaintYesnoValue() {
		return complaintYesnoValue;
	}
	/**
	* 设置： 投诉状态的值
	*/
	public void setComplaintYesnoValue(String complaintYesnoValue) {
		this.complaintYesnoValue = complaintYesnoValue;
	}

//级联表的get和set orderreceiving
	/**
	 * 获取：订单信息 的 任务
	 */
	public Integer getOrderreceivingTaskId() {
		return orderreceivingTaskId;
	}
	/**
	 * 设置：订单信息 的 任务
	 */
	public void setOrderreceivingTaskId(Integer orderreceivingTaskId) {
		this.orderreceivingTaskId = orderreceivingTaskId;
	}
	/**
	 * 获取：订单信息 的 跑腿
	 */
	public Integer getOrderreceivingErrandsId() {
		return orderreceivingErrandsId;
	}
	/**
	 * 设置：订单信息 的 跑腿
	 */
	public void setOrderreceivingErrandsId(Integer orderreceivingErrandsId) {
		this.orderreceivingErrandsId = orderreceivingErrandsId;
	}

	/**
	 * 获取： 订单状态
	 */
	public Integer getOrderreceivingStatusTypes() {
		return orderreceivingStatusTypes;
	}
	/**
	 * 设置： 订单状态
	 */
	public void setOrderreceivingStatusTypes(Integer orderreceivingStatusTypes) {
		this.orderreceivingStatusTypes = orderreceivingStatusTypes;
	}
	/**
	 * 获取： 订单状态的值
	 */
	public String getOrderreceivingStatusValue() {
		return orderreceivingStatusValue;
	}
	/**
	 * 设置： 订单状态的值
	 */
	public void setOrderreceivingStatusValue(String orderreceivingStatusValue) {
		this.orderreceivingStatusValue = orderreceivingStatusValue;
	}
}
