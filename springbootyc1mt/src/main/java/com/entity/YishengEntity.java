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
 * 停车场
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-04 19:59:21
 */
@TableName("yisheng")
public class YishengEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YishengEntity() {
		
	}
	
	public YishengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 停车场号
	 */
					
	private String yishenggonghao;
	
	/**
	 * 停车场名
	 */
					
	private String yishengxingming;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 空车位数
	 */
					
	private String xingbie;
	
	/**
	 * 图片
	 */
					
	private String touxiang;
	
	/**
	 * 停车位
	 */
					
	private String dianhuahaoma;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：停车场号
	 */
	public void setYishenggonghao(String yishenggonghao) {
		this.yishenggonghao = yishenggonghao;
	}
	/**
	 * 获取：停车场号
	 */
	public String getYishenggonghao() {
		return yishenggonghao;
	}
	/**
	 * 设置：停车场名
	 */
	public void setYishengxingming(String yishengxingming) {
		this.yishengxingming = yishengxingming;
	}
	/**
	 * 获取：停车场名
	 */
	public String getYishengxingming() {
		return yishengxingming;
	}
	/**
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
	/**
	 * 设置：空车位数
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：空车位数
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：图片
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：图片
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：停车位
	 */
	public void setDianhuahaoma(String dianhuahaoma) {
		this.dianhuahaoma = dianhuahaoma;
	}
	/**
	 * 获取：停车位
	 */
	public String getDianhuahaoma() {
		return dianhuahaoma;
	}

}
