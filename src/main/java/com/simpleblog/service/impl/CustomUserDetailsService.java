package com.simpleblog.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simpleblog.dao.MemberDao;
import com.simpleblog.entity.Member;

@Service("customUserDetailsService")
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	MemberDao memberDao;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		Member blogMember = memberDao.findByName(name);

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(blogMember.getName(), 
						blogMember.getPassword(),
						enabled, 
						accountNonExpired, 
						credentialsNonExpired,
						accountNonLocked, 
						getAuthorities(blogMember.getRole().getId()));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {  
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));  
	        return authList;  
	}

	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 1) {
			roles.add("ROLE_USER");
			roles.add("ROLE_WRITER");
			roles.add("ROLE_MODERATOR");
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_USER");
			roles.add("ROLE_WRITER");
			roles.add("ROLE_MODERATOR");
		} else if (role.intValue() == 3) {
			roles.add("ROLE_USER");
			roles.add("ROLE_WRITER");
		} else if (role.intValue() == 4) {
			roles.add("ROLE_USER");
		}
		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		
		return authorities;
	}

}
