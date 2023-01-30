package com.example.School;

import com.example.School.model.Student;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SchoolApplicationTests {
//	Validator validator;
//
//	@BeforeEach
//	void setUp() {
//		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//		validator = validatorFactory.getValidator();
//	}

	@Test
	void verifyNameIsAlphabetic(){
		Student student = new Student();
		student.setName("fu4ll name");
		String regex = "^[A-z]{2,15}\\s[A-z]{2,20}$";
		Assert.assertFalse(Pattern.matches(regex,student.getName()));
	}

//	private Student getStudent(String name, String major, String email) {
//		Student student = new Student();
//		student.setName(name);
//		student.setMajor(major);
//		student.setEmail(email);
//		return student;
//	}
//
//	@Test
//	void contextLoads() {
//	}

}
