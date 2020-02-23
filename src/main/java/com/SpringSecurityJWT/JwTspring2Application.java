package com.SpringSecurityJWT;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.SpringSecurityJWT.dao.TaskRepository;
import com.SpringSecurityJWT.entities.AppRole;
import com.SpringSecurityJWT.entities.AppUser;
import com.SpringSecurityJWT.entities.Task;
import com.SpringSecurityJWT.service.AccountService;


@SpringBootApplication
public class JwTspring2Application implements CommandLineRunner{

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(JwTspring2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	accountService.saveUser("admin","123","123");
		accountService.saveUser("user","123","123");
		accountService.saveRole(new AppRole(null,"ADMIN"));
		accountService.saveRole(new AppRole(null,"USER"));
		accountService.addRoleToUser("admin","ADMIN" );
		accountService.addRoleToUser("admin","USER" );
		accountService.addRoleToUser("user","USER" );
		
		Stream.of("T1","T2","T3").forEach(t ->{
			taskRepository.save(new Task(null,t));
		});*/
				
	}

}
