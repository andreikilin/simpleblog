package com.simpleblog.dao;

import com.simpleblog.entity.Role;

public interface RoleDao extends AbstractDao<Role, String>{
	public Role getRole(int id);
}
