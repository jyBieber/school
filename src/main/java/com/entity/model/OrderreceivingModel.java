package com.entity.model;

import com.entity.OrderreceivingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 订单信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class OrderreceivingModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 任务
     */
    private Integer taskId;

    /**
     * 跑腿
     */
    private Integer errandsId;

    /**
     * 订单状态
     */
    private Integer orderreceivingStatusTypes;

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
	 * 获取：任务
	 */
    public Integer getTaskId() {
        return taskId;
    }
    /**
	 * 设置：任务
	 */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取：跑腿
     */
    public Integer getErrandsId() {
        return errandsId;
    }
    /**
     * 设置：跑腿
     */
    public void setErrandsId(Integer errandsId) {
        this.errandsId = errandsId;
    }

    /**
	 * 获取：订单状态
	 */
    public Integer getOrderreceivingStatusTypes() {
        return orderreceivingStatusTypes;
    }
    /**
	 * 设置：订单状态
	 */
    public void setOrderreceivingStatusTypes(Integer orderreceivingStatusTypes) {
        this.orderreceivingStatusTypes = orderreceivingStatusTypes;
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