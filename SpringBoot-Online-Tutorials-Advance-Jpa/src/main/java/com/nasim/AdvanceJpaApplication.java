package com.nasim;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nasim.model.Course;
import com.nasim.model.Review;
import com.nasim.model.Student;
import com.nasim.repository.CourseRepository;
import com.nasim.repository.StudentRepository;

@SpringBootApplication
public class AdvanceJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceJpaApplication.class, args);
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
		
//		studentRepository.SaveStudentWithPasport();
//		List<Review>review=new ArrayList<>();
//		review.add(new Review("5", "Nice Course"));
//		review.add(new Review("5", "Nice Course"));
//
//		courseRepository.InsertCoursetoReview(2,review);
		
		courseRepository.InsertCourseandStudent(new Student("Sumba"),new Course("Java Tutorial"));
	}

}
