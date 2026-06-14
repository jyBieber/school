package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 订单信息
 */
@TableName("orderreceiving")
public class OrderreceivingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

	public OrderreceivingEntity() {

	}

	public OrderreceivingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)
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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Orderreceiving{" +
            "id=" + id +
            ", taskId=" + taskId +
            ", errandsId=" + errandsId +
            ", orderreceivingStatusTypes=" + orderreceivingStatusTypes +
            ", createTime=" + createTime +
        "}";
    }
}
