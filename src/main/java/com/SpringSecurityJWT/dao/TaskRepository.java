package com.SpringSecurityJWT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurityJWT.entities.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {

}

