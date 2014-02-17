package com.simpleblog.service;

import com.simpleblog.entity.Member;

public interface MemberService {
	
	void saveMember(Member member);
	void deleteMember(String memberName);
	Member findByName(String name);
	Member findByEmail(String email);
}
