package com.ga.capitalmgmtplatform.service;

import com.ga.capitalmgmtplatform.pojo.User;

public interface UserRoleService {

	public void setRoles(User user, long[] roleIds);

	public void deleteByUser(long userId);

	public void deleteByRole(long roleId);

}