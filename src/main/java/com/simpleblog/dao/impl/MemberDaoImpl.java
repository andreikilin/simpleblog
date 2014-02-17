package com.simpleblog.dao.impl;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.simpleblog.dao.MemberDao;
import com.simpleblog.entity.Member;

@Repository(value="memberDao")
public class MemberDaoImpl extends AbstractDaoImpl<Member,String> implements MemberDao {
	
	public MemberDaoImpl() {
		super(Member.class);
	}

	
	@Override
	public void addMember(Member member) {
		saveOrUpdate(member);
	}

	@Override
	public Member findByName(String name) {
		List<Member> result = findListByCriteria(
				Restrictions.like("name", name, MatchMode.START)); 
		
		if(result.size() >= 2) {
			System.out.println("Name cannot dublicate");
		}
		return result.size() != 0 ? result.get(0) : null;
	}

	@Override
	public Member findByEmail(String email) {
		List<Member> result = findListByCriteria(
				Restrictions.like("email", email, MatchMode.START)); 
		
		if(result.size() >= 2) {
			System.out.println("Email cannot dublicate");
		}
		return result.size() != 0 ? result.get(0) : null;
		
	}

	
	
	

}
