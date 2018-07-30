package com.ga.capitalmgmtplatform.service;

import com.ga.capitalmgmtplatform.pojo.Role;
import com.ga.capitalmgmtplatform.pojo.User;

import java.util.List;
import java.util.Set;

public interface RoleService {
	public Set<String> listRoleNames(String userName);

	public List<Role> listRoles(String userName);

	public List<Role> listRoles(User user);

	public List<Role> list();

	public void add(Role role);

	public void delete(Long id);

	public Role get(Long id);

	public void update(Role role);

}