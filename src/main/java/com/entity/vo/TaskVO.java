package com.entity.vo;

import com.entity.TaskEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 任务信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("task")
public class TaskVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableField(value = "id")
    private Integer id;

    /**
     * 任务编号
     */
    @TableField(value = "task_uuid_number")
    private String taskUuidNumber;

    /**
     * 用户
     */
    @TableField(value = "yonghu_id")
    private Integer yonghuId;

    /**
     * 任务标题
     */
    @TableField(value = "task_name")
    private String taskName;

    /**
     * 单价
     */
    @TableField(value = "task_money")
    private Double taskMoney;

    /**
     * 任务状态
     */
    @TableField(value = "task_status_types")
    private Integer taskStatusTypes;

    /**
     * 任务详情
     */
    @TableField(value = "task_content")
    private String taskContent;

    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time")
    private Date createTime;

    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
	 * 设置：任务编号
	 */
    public String getTaskUuidNumber() {
        return taskUuidNumber;
    }
    /**
	 * 获取：任务编号
	 */
    public void setTaskUuidNumber(String taskUuidNumber) {
        this.taskUuidNumber = taskUuidNumber;
    }

    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }

    /**
	 * 设置：任务标题
	 */
    public String getTaskName() {
        return taskName;
    }
    /**
	 * 获取：任务标题
	 */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
	 * 设置：单价
	 */
    public Double getTaskMoney() {
        return taskMoney;
    }
    /**
	 * 获取：单价
	 */
    public void setTaskMoney(Double taskMoney) {
        this.taskMoney = taskMoney;
    }

    /**
	 * 设置：任务状态
	 */
    public Integer getTaskStatusTypes() {
        return taskStatusTypes;
    }
    /**
	 * 获取：任务状态
	 */
    public void setTaskStatusTypes(Integer taskStatusTypes) {
        this.taskStatusTypes = taskStatusTypes;
    }

    /**
	 * 设置：任务详情
	 */
    public String getTaskContent() {
        return taskContent;
    }
    /**
	 * 获取：任务详情
	 */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}