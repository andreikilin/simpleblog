package com.simpleblog.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simpleblog.dao.RoleDao;
import com.simpleblog.entity.Role;
import com.simpleblog.service.RoleService;

@Service("roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDao roleDao;
	
	@Override
	public Role getRole(int id) {
		return roleDao.getRole(id);
	}

	
}
