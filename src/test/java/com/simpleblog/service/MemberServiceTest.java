package com.simpleblog.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simpleblog.entity.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dispatcher-servlet.xml"})
public class MemberServiceTest {

	@Autowired
	MemberService memberService;
	
	private final String memberName = "user4test";
/*	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
*/
	@After
	public void tearDown() throws Exception {
		memberService.deleteMember(memberName);
	}

	@Test
	public void testSaveMember() {
		Member member = createMember();
		Member found = memberService.findByName(memberName);
		assertEquals(member, found);
	}
	
	private Member createMember() {
		Member member = new Member(memberName, "proxmox", "populate@email.com");
		memberService.saveMember(member);
		return member;
	}
	
	@Test
	public void testDeleteMember() {
		createMember();
		assertNotNull(memberService.findByName(memberName));
		memberService.deleteMember(memberName);
		assertNull(memberService.findByName(memberName));
		
	}
	
	 @Test
	 public void testUpdateMember() throws Exception {
		 createMember();
		 Member member = memberService.findByName(memberName);
		 assertNotNull(member);
		 assertEquals("user4test", member.getName());
		 assertEquals("populate@email.com", member.getEmail());
		 
		 member.setPassword("newpass");
		 member.setEmail("new4@email.com");
		 memberService.saveMember(member);
		 
		 Member found = memberService.findByName(memberName);
		 assertNotNull(found);
		 assertEquals("newpass", found.getPassword());
		 assertEquals("new4@email.com", found.getEmail());
	 }
/*
	@Test
	public void testFindByName() {
		createMember();
		Member member = memberService.findByName(memberName);
	}

	@Test
	public void testFindByEmail() {
		fail("Not yet implemented");
	}
*/
}
