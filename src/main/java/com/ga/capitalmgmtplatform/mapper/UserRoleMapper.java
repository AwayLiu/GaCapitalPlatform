package com.ga.capitalmgmtplatform.mapper;

import com.ga.capitalmgmtplatform.pojo.UserRole;
import com.ga.capitalmgmtplatform.pojo.UserRoleExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(UserRole record);

	int insertSelective(UserRole record);

	List<UserRole> selectByExample(UserRoleExample example);

	UserRole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserRole record);

	int updateByPrimaryKey(UserRole record);
}