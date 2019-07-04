package com.github.ravik.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.github.ravik.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentResultSetExtractor extractor = new StudentResultSetExtractor();
		return extractor.extractData(rs);
	}
}
