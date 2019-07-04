package com.github.ravik.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.github.ravik.model.Student;

public class StudentResultSetExtractor implements ResultSetExtractor<Student> {

	public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
		Student student = new Student();
		student.setUserName(rs.getString(1));
		student.setFirstName(rs.getString(2));
		student.setLastName(rs.getString(3));
		student.setPassword(rs.getString(4));
		student.setEmailAddress(rs.getString(5));
		student.setDateOfBirth(rs.getDate(6));
		return student;
	}

}