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
 * 停车位
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-04 19:59:21
 */
@TableName("jiancezhandian")
public class JiancezhandianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiancezhandianEntity() {
		
	}
	
	public JiancezhandianEntity(T t) {
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
	 * 车位编号
	 */
					
	private String zhandianbianhao;
	
	/**
	 * 车位名称
	 */
					
	private String zhandianmingcheng;
	
	/**
	 * 占用
	 */
					
	private String xiangmuleixing;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 详细地址
	 */
					
	private String xiangxidizhi;
	
	/**
	 * 营业时间
	 */
					
	private String zaigangshijian;
	
	/**
	 * 咨询电话
	 */
					
	private String zixundianhua;
	
	/**
	 * 停车位详情
	 */
					
	private String zhandianxiangqing;
	
	/**
	 * 停车场号
	 */
					
	private String yishenggonghao;
	
	/**
	 * 停车场名
	 */
					
	private String yishengxingming;
	
	
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
	 * 设置：车位编号
	 */
	public void setZhandianbianhao(String zhandianbianhao) {
		this.zhandianbianhao = zhandianbianhao;
	}
	/**
	 * 获取：车位编号
	 */
	public String getZhandianbianhao() {
		return zhandianbianhao;
	}
	/**
	 * 设置：车位名称
	 */
	public void setZhandianmingcheng(String zhandianmingcheng) {
		this.zhandianmingcheng = zhandianmingcheng;
	}
	/**
	 * 获取：车位名称
	 */
	public String getZhandianmingcheng() {
		return zhandianmingcheng;
	}
	/**
	 * 设置：占用
	 */
	public void setXiangmuleixing(String xiangmuleixing) {
		this.xiangmuleixing = xiangmuleixing;
	}
	/**
	 * 获取：占用
	 */
	public String getXiangmuleixing() {
		return xiangmuleixing;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：详细地址
	 */
	public void setXiangxidizhi(String xiangxidizhi) {
		this.xiangxidizhi = xiangxidizhi;
	}
	/**
	 * 获取：详细地址
	 */
	public String getXiangxidizhi() {
		return xiangxidizhi;
	}
	/**
	 * 设置：营业时间
	 */
	public void setZaigangshijian(String zaigangshijian) {
		this.zaigangshijian = zaigangshijian;
	}
	/**
	 * 获取：营业时间
	 */
	public String getZaigangshijian() {
		return zaigangshijian;
	}
	/**
	 * 设置：咨询电话
	 */
	public void setZixundianhua(String zixundianhua) {
		this.zixundianhua = zixundianhua;
	}
	/**
	 * 获取：咨询电话
	 */
	public String getZixundianhua() {
		return zixundianhua;
	}
	/**
	 * 设置：停车位详情
	 */
	public void setZhandianxiangqing(String zhandianxiangqing) {
		this.zhandianxiangqing = zhandianxiangqing;
	}
	/**
	 * 获取：停车位详情
	 */
	public String getZhandianxiangqing() {
		return zhandianxiangqing;
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

}
