package com.entity.model;

import com.entity.ComplaintEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 投诉信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ComplaintModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 订单
     */
    private Integer orderreceivingId;

    /**
     * 投诉标题
     */
    private String complaintName;

    /**
     * 投诉类型
     */
    private Integer complaintTypes;

    /**
     * 投诉原因
     */
    private String complaintText;

    /**
     * 投诉状态
     */
    private Integer complaintYesnoTypes;

    /**
     * 投诉详情
     */
    private String complaintYesnoText;

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
     * 获取：订单
     */
    public Integer getOrderreceivingId() {
        return orderreceivingId;
    }
    /**
     * 设置：订单
     */
    public void setOrderreceivingId(Integer orderreceivingId) {
        this.orderreceivingId = orderreceivingId;
    }

    /**
	 * 获取：投诉标题
	 */
    public String getComplaintName() {
        return complaintName;
    }
    /**
	 * 设置：投诉标题
	 */
    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName;
    }

    /**
	 * 获取：投诉类型
	 */
    public Integer getComplaintTypes() {
        return complaintTypes;
    }
    /**
	 * 设置：投诉类型
	 */
    public void setComplaintTypes(Integer complaintTypes) {
        this.complaintTypes = complaintTypes;
    }

    /**
	 * 获取：投诉原因
	 */
    public String getComplaintText() {
        return complaintText;
    }
    /**
	 * 设置：投诉原因
	 */
    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    /**
	 * 获取：投诉状态
	 */
    public Integer getComplaintYesnoTypes() {
        return complaintYesnoTypes;
    }
    /**
	 * 设置：投诉状态
	 */
    public void setComplaintYesnoTypes(Integer complaintYesnoTypes) {
        this.complaintYesnoTypes = complaintYesnoTypes;
    }

    /**
	 * 获取：投诉详情
	 */
    public String getComplaintYesnoText() {
        return complaintYesnoText;
    }
    /**
	 * 设置：投诉详情
	 */
    public void setComplaintYesnoText(String complaintYesnoText) {
        this.complaintYesnoText = complaintYesnoText;
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