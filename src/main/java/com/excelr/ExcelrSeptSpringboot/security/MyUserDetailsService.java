package com.excelr.ExcelrSeptSpringboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.excelr.ExcelrSeptSpringboot.entity.DBUser;
import com.excelr.ExcelrSeptSpringboot.repository.DBUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	DBUserRepository dbUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		DBUser user= dbUserRepository.findByUsername(username);
		if (user==null)
			throw new UsernameNotFoundException("User does not exist");
		return new MyUserDecorator(user);
	}

}
