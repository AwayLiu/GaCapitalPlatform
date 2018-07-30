package com.ga.capitalmgmtplatform.mapper;

import com.ga.capitalmgmtplatform.pojo.Role;
import com.ga.capitalmgmtplatform.pojo.RoleExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Role record);

	int insertSelective(Role record);

	List<Role> selectByExample(RoleExample example);

	Role selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);
}