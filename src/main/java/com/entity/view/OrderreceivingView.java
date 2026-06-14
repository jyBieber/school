package com.entity.view;

import com.entity.OrderreceivingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("orderreceiving")
public class OrderreceivingView extends OrderreceivingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	* 订单状态的值
	*/
	private String orderreceivingStatusValue;

	//级联表 task
	/**
	* 任务编号
	*/
	private String taskUuidNumber;
	/**
	* 任务信息 的 用户
	*/
	private Integer taskYonghuId;
	/**
	* 任务标题
	*/
	private String taskName;
	/**
	* 单价
	*/
	private Double taskMoney;
	/**
	* 任务状态
	*/
	private Integer taskStatusTypes;
	/**
	* 任务状态的值
	*/
	private String taskStatusValue;
	/**
	* 任务详情
	*/
	private String taskContent;

	//级联表 errands
	/**
	 * 跑腿姓名
	 */
	private String errandsName;
	/**
	 * 头像
	 */
	private String errandsPhoto;
	/**
	 * 联系方式
	 */
	private String errandsPhone;
	/**
	 * 邮箱
	 */
	private String errandsEmail;
	/**
	 * 假删
	 */
	private Integer errandsDelete;

	public OrderreceivingView() {

	}

	public OrderreceivingView(OrderreceivingEntity orderreceivingEntity) {
		try {
			BeanUtils.copyProperties(this, orderreceivingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	//级联表的get和set task
	/**
	* 获取： 任务编号
	*/
	public String getTaskUuidNumber() {
		return taskUuidNumber;
	}
	/**
	* 设置： 任务编号
	*/
	public void setTaskUuidNumber(String taskUuidNumber) {
		this.taskUuidNumber = taskUuidNumber;
	}
	/**
	* 获取：任务信息 的 用户
	*/
	public Integer getTaskYonghuId() {
		return taskYonghuId;
	}
	/**
	* 设置：任务信息 的 用户
	*/
	public void setTaskYonghuId(Integer taskYonghuId) {
		this.taskYonghuId = taskYonghuId;
	}

	/**
	* 获取： 任务标题
	*/
	public String getTaskName() {
		return taskName;
	}
	/**
	* 设置： 任务标题
	*/
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	* 获取： 单价
	*/
	public Double getTaskMoney() {
		return taskMoney;
	}
	/**
	* 设置： 单价
	*/
	public void setTaskMoney(Double taskMoney) {
		this.taskMoney = taskMoney;
	}
	/**
	* 获取： 任务状态
	*/
	public Integer getTaskStatusTypes() {
		return taskStatusTypes;
	}
	/**
	* 设置： 任务状态
	*/
	public void setTaskStatusTypes(Integer taskStatusTypes) {
		this.taskStatusTypes = taskStatusTypes;
	}
	/**
	* 获取： 任务状态的值
	*/
	public String getTaskStatusValue() {
		return taskStatusValue;
	}
	/**
	* 设置： 任务状态的值
	*/
	public void setTaskStatusValue(String taskStatusValue) {
		this.taskStatusValue = taskStatusValue;
		}
	/**
	* 获取： 任务详情
	*/
	public String getTaskContent() {
		return taskContent;
	}
	/**
	* 设置： 任务详情
	*/
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	//级联表的get和set errands
	/**
	 * 获取： 跑腿姓名
	 */
	public String getErrandsName() {
		return errandsName;
	}
	/**
	 * 设置： 跑腿姓名
	 */
	public void setErrandsName(String errandsName) {
		this.errandsName = errandsName;
	}
	/**
	 * 获取： 头像
	 */
	public String getErrandsPhoto() {
		return errandsPhoto;
	}
	/**
	 * 设置： 头像
	 */
	public void setErrandsPhoto(String errandsPhoto) {
		this.errandsPhoto = errandsPhoto;
	}
	/**
	 * 获取： 联系方式
	 */
	public String getErrandsPhone() {
		return errandsPhone;
	}
	/**
	 * 设置： 联系方式
	 */
	public void setErrandsPhone(String errandsPhone) {
		this.errandsPhone = errandsPhone;
	}
	/**
	 * 获取： 邮箱
	 */
	public String getErrandsEmail() {
		return errandsEmail;
	}
	/**
	 * 设置： 邮箱
	 */
	public void setErrandsEmail(String errandsEmail) {
		this.errandsEmail = errandsEmail;
	}
	/**
	 * 获取： 假删
	 */
	public Integer getErrandsDelete() {
		return errandsDelete;
	}
	/**
	 * 设置： 假删
	 */
	public void setErrandsDelete(Integer errandsDelete) {
		this.errandsDelete = errandsDelete;
	}
}