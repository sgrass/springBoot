package com.cx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cx.model.CmsUser;

@Mapper
public interface CmsUserMapper {
	
	@Select("select * from cms_user")
  public List<CmsUser> queryAll();
 
  @Select("select * from cms_user where id = #{id}")
  public CmsUser queryById(Integer id);
 
}
