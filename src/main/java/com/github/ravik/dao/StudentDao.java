package com.github.ravik.dao;

import java.util.List;

import com.github.ravik.model.Student;

public interface StudentDao {
	public int save(Student student);
	public List<Student> findAll();
	public boolean findByLogin(String userName, String password);
	public boolean findByUserName(String userName);
}
