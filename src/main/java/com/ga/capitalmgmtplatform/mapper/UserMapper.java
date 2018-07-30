package com.ga.capitalmgmtplatform.mapper;

import com.ga.capitalmgmtplatform.pojo.User;
import com.ga.capitalmgmtplatform.pojo.UserExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}