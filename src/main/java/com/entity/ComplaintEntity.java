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
 * 投诉信息
 *
 * @author 
 * @email
 */
@TableName("complaint")
public class ComplaintEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

	public ComplaintEntity() {

	}

	public ComplaintEntity(T t) {
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
     * 订单
     */
    @TableField(value = "orderreceiving_id")
    private Integer orderreceivingId;

    /**
     * 投诉标题
     */
    @TableField(value = "complaint_name")
    private String complaintName;

    /**
     * 投诉类型
     */
    @TableField(value = "complaint_types")
    private Integer complaintTypes;

    /**
     * 投诉原因
     */
    @TableField(value = "complaint_text")
    private String complaintText;

    /**
     * 投诉状态
     */
    @TableField(value = "complaint_yesno_types")
    private Integer complaintYesnoTypes;

    /**
     * 投诉详情
     */
    @TableField(value = "complaint_yesno_text")
    private String complaintYesnoText;

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
    public Integer getOrderreceivingId() {
        return orderreceivingId;
    }
    /**
     * 获取：任务
     */
    public void setOrderreceivingId(Integer orderreceivingId) {
        this.orderreceivingId = orderreceivingId;
    }

    /**
	 * 设置：投诉标题
	 */
    public String getComplaintName() {
        return complaintName;
    }
    /**
	 * 获取：投诉标题
	 */
    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName;
    }

    /**
	 * 设置：投诉类型
	 */
    public Integer getComplaintTypes() {
        return complaintTypes;
    }
    /**
	 * 获取：投诉类型
	 */
    public void setComplaintTypes(Integer complaintTypes) {
        this.complaintTypes = complaintTypes;
    }

    /**
	 * 设置：投诉原因
	 */
    public String getComplaintText() {
        return complaintText;
    }
    /**
	 * 获取：投诉原因
	 */
    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    /**
	 * 设置：投诉状态
	 */
    public Integer getComplaintYesnoTypes() {
        return complaintYesnoTypes;
    }
    /**
	 * 获取：投诉状态
	 */
    public void setComplaintYesnoTypes(Integer complaintYesnoTypes) {
        this.complaintYesnoTypes = complaintYesnoTypes;
    }

    /**
	 * 设置：投诉详情
	 */
    public String getComplaintYesnoText() {
        return complaintYesnoText;
    }
    /**
	 * 获取：投诉详情
	 */
    public void setComplaintYesnoText(String complaintYesnoText) {
        this.complaintYesnoText = complaintYesnoText;
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
        return "Complaint{" +
            "id=" + id +
            ", orderreceivingId=" + orderreceivingId +
            ", complaintName=" + complaintName +
            ", complaintTypes=" + complaintTypes +
            ", complaintText=" + complaintText +
            ", complaintYesnoTypes=" + complaintYesnoTypes +
            ", complaintYesnoText=" + complaintYesnoText +
            ", createTime=" + createTime +
        "}";
    }
}
