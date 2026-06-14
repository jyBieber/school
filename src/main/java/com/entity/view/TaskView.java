package com.entity.view;

import com.entity.TaskEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 任务信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("task")
public class TaskView extends TaskEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	/**
	* 任务类型的值
	*/
	private String taskValue;
	/**
	* 任务状态的值
	*/
	private String taskStatusValue;

	//级联表 yonghu
	/**
	* 用户姓名
	*/
	private String yonghuName;
	/**
	* 头像
	*/
	private String yonghuPhoto;
	/**
	* 联系方式
	*/
	private String yonghuPhone;
	/**
	* 邮箱
	*/
	private String yonghuEmail;
	/**
	* 假删
	*/
	private Integer yonghuDelete;

	public TaskView() {

	}

	public TaskView(TaskEntity taskEntity) {
		try {
			BeanUtils.copyProperties(this, taskEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	* 获取： 任务类型的值
	*/
	public String getTaskValue() {
		return taskValue;
	}
	/**
	* 设置： 任务类型的值
	*/
	public void setTaskValue(String taskValue) {
		this.taskValue = taskValue;
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

	//级联表的get和set yonghu
	/**
	* 获取： 用户姓名
	*/
	public String getYonghuName() {
		return yonghuName;
	}
	/**
	* 设置： 用户姓名
	*/
	public void setYonghuName(String yonghuName) {
		this.yonghuName = yonghuName;
	}
	/**
	* 获取： 头像
	*/
	public String getYonghuPhoto() {
		return yonghuPhoto;
	}
	/**
	* 设置： 头像
	*/
	public void setYonghuPhoto(String yonghuPhoto) {
		this.yonghuPhoto = yonghuPhoto;
	}
	/**
	* 获取： 联系方式
	*/
	public String getYonghuPhone() {
		return yonghuPhone;
	}
	/**
	* 设置： 联系方式
	*/
	public void setYonghuPhone(String yonghuPhone) {
		this.yonghuPhone = yonghuPhone;
	}
	/**
	* 获取： 邮箱
	*/
	public String getYonghuEmail() {
		return yonghuEmail;
	}
	/**
	* 设置： 邮箱
	*/
	public void setYonghuEmail(String yonghuEmail) {
		this.yonghuEmail = yonghuEmail;
	}
	/**
	* 获取： 假删
	*/
	public Integer getYonghuDelete() {
		return yonghuDelete;
	}
	/**
	* 设置： 假删
	*/
	public void setYonghuDelete(Integer yonghuDelete) {
		this.yonghuDelete = yonghuDelete;
	}
}