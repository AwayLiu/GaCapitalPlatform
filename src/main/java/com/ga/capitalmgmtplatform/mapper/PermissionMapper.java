package com.ga.capitalmgmtplatform.mapper;

import com.ga.capitalmgmtplatform.pojo.Permission;
import com.ga.capitalmgmtplatform.pojo.PermissionExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Permission record);

	int insertSelective(Permission record);

	List<Permission> selectByExample(PermissionExample example);

	Permission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);
}