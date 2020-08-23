package com.nasim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nasim.model.Course;
import com.nasim.repository.CourseRepository;
import com.nasim.repository.StudentRepository;

@SpringBootApplication
public class SpringBootOnlineTutorialsAdvanceJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOnlineTutorialsAdvanceJpaApplication.class, args);
	}

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

//		logger.info("Finding course {}", courseRepository.findById(1));
//		
//		courseRepository.deleteBYId(5);
//		
//		courseRepository.SaveOrUpdate(new Course("Sagoto"));
		
		studentRepository.SaveStudentWithPasport();
	}

}
