package com.SpringSecurityJWT.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurityJWT.entities.AppUser;
import com.SpringSecurityJWT.service.AccountService;



@RestController
public class UserController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm) {
		
		return accountService.saveUser(userForm.getUsername(), userForm.getPassword(), userForm.getRepassword()); 
	}

}
