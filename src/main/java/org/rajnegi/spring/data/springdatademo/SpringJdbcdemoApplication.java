package org.rajnegi.spring.data.springdatademo;

import java.util.Date;

import org.rajnegi.spring.data.springdatademo.entity.Person;
import org.rajnegi.spring.data.springdatademo.jdbc.IPersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//When the spring application context is ready the code in the CommandLinerunner gets executed.
public class SpringJdbcdemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IPersonDao personRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", personRepo.findAll());
		logger.info("Find by Id 10001 -> {}", personRepo.findById(10001));
		logger.info("Find by location Thane -> {}", personRepo.findByLocation("Thane"));
		logger.info("Find by name Laisha Negi -> {}", personRepo.findByName("Laisha Negi"));
		logger.info("Deleting 10002 ; No of rows deleted {}", personRepo.deleteById(10002));
		logger.info("Inserting new Person 10004; No of rows inserted {}", 
				personRepo.insert(new Person(10004, "Bachha Negi", "Sydney", new Date())));
		logger.info("Updating person 10001; No of rows updated {}", 
				personRepo.update(new Person(10001, "Laxmi Negi", "Vasai", new Date())));
	}
}
