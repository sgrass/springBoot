package com.cx.web;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cx.model.CmsUser;
import com.cx.service.CmsUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping(value="/cmsUser")
public class CmsUserController {

	@Autowired
	private CmsUserService cmsUserService;
	
  @Autowired
  private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping(value="queryAll")
	public List<CmsUser> queryAll() {
		//分页,第一页，2条
		PageHelper.startPage(1,2);
		List<CmsUser> list = cmsUserService.queryAll();
		PageInfo<CmsUser> page = new PageInfo<CmsUser>(list);
		System.out.println(page.getSize());
		System.out.println(page.getTotal());
		return list;
	}
	
	@RequestMapping(value="queryById/{id}")
	public CmsUser queryById(@PathVariable Integer id) {
	  redisTemplate.opsForValue().set("bbb", "aaa", 5L, TimeUnit.SECONDS);
	  redisTemplate.opsForHash().put("test", "1", "AAAAAAA");
	  
	  CmsUser cmsUser= null;
	  if (redisTemplate.hasKey("user")) {
	    cmsUser = (CmsUser) redisTemplate.opsForValue().get("user");
	  } else {
	    cmsUser = cmsUserService.queryById(id);
	    redisTemplate.opsForValue().set("user",cmsUser, 5, TimeUnit.SECONDS);
	  }
		return cmsUser;
	}
}
