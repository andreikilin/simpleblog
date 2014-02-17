package com.simpleblog.dao;

import com.simpleblog.entity.Member;

public interface MemberDao extends AbstractDao<Member, String>{
	
	void addMember(Member member);
	Member findByName(String name);
	Member findByEmail(String email);
	
	
}
