package com.cx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.mapper.CmsUserMapper;
import com.cx.model.CmsUser;

@Service("cmsUserService")
public class CmsUserService {
	
	@Autowired
	private CmsUserMapper cmsUserMapper;
	
	public List<CmsUser> queryAll() {
		return cmsUserMapper.queryAll();
	}
	
	public CmsUser queryById(Integer id) {
		return cmsUserMapper.queryById(id);
	}
}
