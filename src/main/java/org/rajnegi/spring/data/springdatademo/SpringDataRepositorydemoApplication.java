package org.rajnegi.spring.data.springdatademo;

import java.util.Date;

import org.rajnegi.spring.data.springdatademo.entity.Person;
import org.rajnegi.spring.data.springdatademo.springdata.ISpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//When the spring application context is ready the code in the CommandLinerunner gets executed.
public class SpringDataRepositorydemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ISpringDataRepository personRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataRepositorydemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Find by Id 10001 -> {}", personRepo.findById(10001));
		personRepo.deleteById(10002);
		
		Person person = new Person("Akka Bakka", "Sydney", new Date());
		personRepo.save(person);
		logger.info("Inserting new Person {}", person);
		
		person.setLocation("Melbourne");
		personRepo.save(person);
		logger.info("Updating person {}", person);
		
		logger.info("All users -> {}", personRepo.findAll());
	}
}
