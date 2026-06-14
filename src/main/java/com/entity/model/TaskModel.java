package com.entity.model;

import com.entity.TaskEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 任务信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TaskModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 任务编号
     */
    private String taskUuidNumber;

    /**
     * 用户
     */
    private Integer yonghuId;

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
     * 任务详情
     */
    private String taskContent;

    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;

    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
	 * 获取：任务编号
	 */
    public String getTaskUuidNumber() {
        return taskUuidNumber;
    }
    /**
	 * 设置：任务编号
	 */
    public void setTaskUuidNumber(String taskUuidNumber) {
        this.taskUuidNumber = taskUuidNumber;
    }

    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }

    /**
	 * 获取：任务标题
	 */
    public String getTaskName() {
        return taskName;
    }
    /**
	 * 设置：任务标题
	 */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
	 * 获取：单价
	 */
    public Double getTaskMoney() {
        return taskMoney;
    }
    /**
	 * 设置：单价
	 */
    public void setTaskMoney(Double taskMoney) {
        this.taskMoney = taskMoney;
    }

    /**
	 * 获取：任务状态
	 */
    public Integer getTaskStatusTypes() {
        return taskStatusTypes;
    }
    /**
	 * 设置：任务状态
	 */
    public void setTaskStatusTypes(Integer taskStatusTypes) {
        this.taskStatusTypes = taskStatusTypes;
    }

    /**
	 * 获取：任务详情
	 */
    public String getTaskContent() {
        return taskContent;
    }
    /**
	 * 设置：任务详情
	 */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}