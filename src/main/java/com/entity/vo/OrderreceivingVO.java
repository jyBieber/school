package com.entity.vo;

import com.entity.OrderreceivingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 订单信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("orderreceiving")
public class OrderreceivingVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableField(value = "id")
    private Integer id;

    /**
     * 任务
     */
    @TableField(value = "task_id")
    private Integer taskId;

    /**
     * 跑腿
     */
    @TableField(value = "errands_id")
    private Integer errandsId;

    /**
     * 订单状态
     */
    @TableField(value = "orderreceiving_status_types")
    private Integer orderreceivingStatusTypes;

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
	 * 设置：任务
	 */
    public Integer getTaskId() {
        return taskId;
    }
    /**
	 * 获取：任务
	 */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * 设置：跑腿
     */
    public Integer getErrandsId() {
        return errandsId;
    }
    /**
     * 获取：跑腿
     */
    public void setErrandsId(Integer errandsId) {
        this.errandsId = errandsId;
    }

    /**
	 * 设置：订单状态
	 */
    public Integer getOrderreceivingStatusTypes() {
        return orderreceivingStatusTypes;
    }
    /**
	 * 获取：订单状态
	 */
    public void setOrderreceivingStatusTypes(Integer orderreceivingStatusTypes) {
        this.orderreceivingStatusTypes = orderreceivingStatusTypes;
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