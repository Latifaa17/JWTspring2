package com.SpringSecurityJWT.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringSecurityJWT.dao.AppRoleRepository;
import com.SpringSecurityJWT.dao.AppUserRepository;
import com.SpringSecurityJWT.entities.AppRole;
import com.SpringSecurityJWT.entities.AppUser;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private AppRoleRepository appRoleRepository;
	
	
	
	@Override
	public AppUser saveUser(String username, String password, String repassword) {
		AppUser user = appUserRepository.findByUsername(username);
		if(user!=null)
			throw new RuntimeException("exists");
		if (!password.equals(repassword))
			throw new RuntimeException("confirm password");
		
		AppUser  appUser = new AppUser();
		appUser.setUsername(username);
		//appUser.setActived(true);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		appUserRepository.save(appUser);
		addRoleToUser(username, "USER");
		return appUser;
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role = appRoleRepository.findByRoleName(roleName);
		AppUser user = appUserRepository.findByUsername(username);
		user.getRoles().add(role);		
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

}
