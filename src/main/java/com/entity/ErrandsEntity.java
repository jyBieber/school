package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 跑腿
 */
@TableName("errands")
public class ErrandsEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

	public ErrandsEntity() {

	}

	public ErrandsEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 跑腿姓名
     */
    @TableField(value = "errands_name")
    private String errandsName;

    /**
     * 头像
     */
    @TableField(value = "errands_photo")
    private String errandsPhoto;

    /**
     * 性别
     */
    @TableField(value = "sex_types")
    private Integer sexTypes;

    /**
     * 联系方式
     */
    @TableField(value = "errands_phone")
    private String errandsPhone;

    /**
     * 邮箱
     */
    @TableField(value = "errands_email")
    private String errandsEmail;


    /**
     * 假删
     */
    @TableField(value = "errands_delete")
    private Integer errandsDelete;

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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
	 * 设置：跑腿姓名
	 */
    public String getErrandsName() {
        return errandsName;
    }
    /**
	 * 获取：跑腿姓名
	 */
    public void setErrandsName(String errandsName) {
        this.errandsName = errandsName;
    }

    /**
	 * 设置：头像
	 */
    public String getErrandsPhoto() {
        return errandsPhoto;
    }
    /**
	 * 获取：头像
	 */
    public void setErrandsPhoto(String errandsPhoto) {
        this.errandsPhoto = errandsPhoto;
    }

    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }

    /**
	 * 设置：联系方式
	 */
    public String getErrandsPhone() {
        return errandsPhone;
    }
    /**
	 * 获取：联系方式
	 */
    public void setErrandsPhone(String errandsPhone) {
        this.errandsPhone = errandsPhone;
    }


    /**
	 * 设置：邮箱
	 */
    public String getErrandsEmail() {
        return errandsEmail;
    }
    /**
	 * 获取：邮箱
	 */
    public void setErrandsEmail(String errandsEmail) {
        this.errandsEmail = errandsEmail;
    }

    /**
	 * 设置：假删
	 */
    public Integer getErrandsDelete() {
        return errandsDelete;
    }
    /**
	 * 获取：假删
	 */
    public void setErrandsDelete(Integer errandsDelete) {
        this.errandsDelete = errandsDelete;
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
        return "Errands{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", errandsName=" + errandsName +
            ", errandsPhoto=" + errandsPhoto +
            ", sexTypes=" + sexTypes +
            ", errandsPhone=" + errandsPhone +
            ", errandsEmail=" + errandsEmail +
            ", errandsDelete=" + errandsDelete +
            ", createTime=" + createTime +
        "}";
    }
}
