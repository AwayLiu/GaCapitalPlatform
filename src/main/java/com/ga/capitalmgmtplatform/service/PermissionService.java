package com.ga.capitalmgmtplatform.service;

import com.ga.capitalmgmtplatform.pojo.Permission;
import com.ga.capitalmgmtplatform.pojo.Role;

import java.util.List;
import java.util.Set;

public interface PermissionService {
	public Set<String> listPermissions(String userName);

	public List<Permission> list();

	public void add(Permission permission);

	public void delete(Long id);

	public Permission get(Long id);

	public void update(Permission permission);

	public List<Permission> list(Role role);

	public boolean needInterceptor(String requestURI);

	public Set<String> listPermissionURLs(String userName);

}