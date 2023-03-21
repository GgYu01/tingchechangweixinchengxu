package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.dao.YuyuexinxiDao;
import com.entity.YuyuexinxiEntity;
import com.entity.model.YuyuexinxiModel;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiancezhandianEntity;
import com.entity.view.JiancezhandianView;

import com.service.JiancezhandianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * 停车位
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-04 19:59:21
 */
@RestController
@RequestMapping("/jiancezhandian")
public class JiancezhandianController {
    @Autowired
    private JiancezhandianService jiancezhandianService;
    @Resource
    private YuyuexinxiDao yuyuexinxiDao;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiancezhandianEntity jiancezhandian,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			jiancezhandian.setYishenggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiancezhandianEntity> ew = new EntityWrapper<JiancezhandianEntity>();
		PageUtils page = jiancezhandianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiancezhandian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiancezhandianEntity jiancezhandian, 
		HttpServletRequest request){

        List<YuyuexinxiEntity> list = yuyuexinxiDao.selectList(null);
        list = list.stream().filter(item -> item.getZhandianmingcheng() != null).collect(Collectors.toList());
        Set<String> alreadySet = list.stream().map(YuyuexinxiEntity::getZhandianmingcheng).collect(Collectors.toSet());


        EntityWrapper<JiancezhandianEntity> ew = new EntityWrapper<JiancezhandianEntity>();
        ew.notIn("zhandianmingcheng",alreadySet);
		PageUtils page = jiancezhandianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiancezhandian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiancezhandianEntity jiancezhandian){
       	EntityWrapper<JiancezhandianEntity> ew = new EntityWrapper<JiancezhandianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiancezhandian, "jiancezhandian")); 
        return R.ok().put("data", jiancezhandianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiancezhandianEntity jiancezhandian){
        EntityWrapper< JiancezhandianEntity> ew = new EntityWrapper< JiancezhandianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiancezhandian, "jiancezhandian")); 
		JiancezhandianView jiancezhandianView =  jiancezhandianService.selectView(ew);
		return R.ok("查询停车位成功").put("data", jiancezhandianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiancezhandianEntity jiancezhandian = jiancezhandianService.selectById(id);
        return R.ok().put("data", jiancezhandian);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiancezhandianEntity jiancezhandian = jiancezhandianService.selectById(id);
        return R.ok().put("data", jiancezhandian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiancezhandianEntity jiancezhandian, HttpServletRequest request){
    	jiancezhandian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiancezhandian);
        jiancezhandianService.insert(jiancezhandian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiancezhandianEntity jiancezhandian, HttpServletRequest request){
    	jiancezhandian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiancezhandian);
        jiancezhandianService.insert(jiancezhandian);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JiancezhandianEntity jiancezhandian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiancezhandian);
        jiancezhandianService.updateById(jiancezhandian);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiancezhandianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JiancezhandianEntity> wrapper = new EntityWrapper<JiancezhandianEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			wrapper.eq("yishenggonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = jiancezhandianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
