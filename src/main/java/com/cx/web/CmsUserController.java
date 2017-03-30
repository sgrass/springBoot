package com.cx.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		return cmsUserService.queryById(id);
	}
}
