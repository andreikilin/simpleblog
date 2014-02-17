package com.simpleblog.dao.impl;

import org.springframework.stereotype.Repository;

import com.simpleblog.dao.RoleDao;
import com.simpleblog.entity.Role;

@Repository(value="roleDao")
public class RoleDaoImpl extends AbstractDaoImpl<Role, String> implements RoleDao{

	public RoleDaoImpl() {
		super(Role.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Role getRole(int id) {
		Role role = (Role) getCurrentSession().load(Role.class, id);  
        return role;
	}

	
}
