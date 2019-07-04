package com.github.ravik.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.ravik.dao.StudentDao;
import com.github.ravik.dao.mapper.StudentRowMapper;
import com.github.ravik.model.Student;

@Service("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public int save(Student student) {
		return jdbcTemplate.update(
				"INSERT INTO STUDENT (USERNAME, FIRSTNAME, LASTNAME, PASSWORD, EMAILADDRESS, DATEOFBIRTH) VALUES(?,?,?,?,?,?)",
				new Object[] { student.getUserName(), student.getFirstName(), student.getLastName(),
						student.getPassword(), student.getEmailAddress(), student.getDateOfBirth() });
	}

	public List<Student> findAll() {
		List<Student> students = jdbcTemplate.query(
				"SELECT USERNAME, FIRSTNAME, LASTNAME, PASSWORD, EMAILADDRESS, DATEOFBIRTH FROM STUDENT ",
				new StudentRowMapper());
		return students;
	}

	public boolean findByLogin(String userName, String password) {
		List<Student> students = jdbcTemplate.query("SELECT USERNAME, FIRSTNAME, LASTNAME, PASSWORD, EMAILADDRESS, DATEOFBIRTH FROM STUDENT WHERE USERNAME=? AND PASSWORD=? ",
				new Object[] { userName, password }, new StudentRowMapper());
		if (students != null && students.size() != 0) {
			return true;
		}
		return false;
	}

	public boolean findByUserName(String userName) {
		List<Student> students = jdbcTemplate.query("SELECT USERNAME, FIRSTNAME, LASTNAME, PASSWORD, EMAILADDRESS, DATEOFBIRTH FROM STUDENT WHERE USERNAME=? ", new Object[] { userName },
				new StudentRowMapper());
		if (students != null && students.size() != 0) {
			return true;
		}
		return false;
	}

}
