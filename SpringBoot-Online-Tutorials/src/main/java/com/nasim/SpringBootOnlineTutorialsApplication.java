package com.nasim;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nasim.jdbc.PersonJdbcDao;
import com.nasim.jpa.Person;
import com.nasim.jpa.PersonJpaRepository;


@SpringBootApplication
public class SpringBootOnlineTutorialsApplication  implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootOnlineTutorialsApplication.class, args);
	}

	 Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Autowired
//	PersonJdbcDao dao;
	 
	 @Autowired
		PersonJpaRepository jpaRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		logger.info("All user {}",dao.findAll());
	
		logger.info("All user {}",jpaRepository.findAll());
		
//		logger.info("Spacific person {}", dao.findById(2));
         
		logger.info("Spacific person {}", jpaRepository.findBYId(2));
		
//		logger.info("Delete one persons id {}", dao.deleteById(8));
		
		 jpaRepository.deleteBYId(8);
	
//		logger.info("Create new person {}", dao.insert(new Person(11,"Borshan","Thakurgaw",new Date())));
	
		logger.info("Create new person {}", jpaRepository.SaveOrUpdate(new Person(11,"Borshan","Thakurgaw",new Date())));

//		logger.info("Updating {}", dao.update(new Person(2,"Kabir","Dhaka",new Date())));
		
		logger.info("Create new person {}", jpaRepository.SaveOrUpdate(new Person(2,"Kabir","Dhaka",new Date())));


	}

}
