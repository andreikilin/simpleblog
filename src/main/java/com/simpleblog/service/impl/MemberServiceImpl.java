package com.simpleblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simpleblog.dao.MemberDao;
import com.simpleblog.entity.Member;
import com.simpleblog.service.MemberService;

@Service("memberService")
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	@Transactional(readOnly = false)
	public void saveMember(Member member) {
		memberDao.addMember(member);
		
	}
	
	@Override
	@Transactional(readOnly = false)
	public void deleteMember(String memberName) {
		Member member = memberDao.findByName(memberName);
		if(member != null) {
			memberDao.delete(member);
		}
	}

	@Override
	public Member findByName(String name) {
		return memberDao.findByName(name);
	}

	@Override
	public Member findByEmail(String email) {
		return memberDao.findByEmail(email);
	}

	

}
