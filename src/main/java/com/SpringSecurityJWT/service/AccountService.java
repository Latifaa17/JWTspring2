package com.SpringSecurityJWT.service;

import com.SpringSecurityJWT.entities.AppRole;
import com.SpringSecurityJWT.entities.AppUser;

public interface AccountService {

	public AppUser saveUser(String username, String password, String repassword);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username, String roleName);
	public AppUser loadUserByUsername(String username);
}
