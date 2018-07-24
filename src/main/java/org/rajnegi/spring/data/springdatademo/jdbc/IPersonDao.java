package org.rajnegi.spring.data.springdatademo.jdbc;

import java.util.List;

import org.rajnegi.spring.data.springdatademo.entity.Person;

public interface IPersonDao {
	
	List<Person> findAll();
	
	Person findById(int id);
	
	List<Person> findByLocation(String location);
	
	Person findByName(String name);
	
	int deleteById(int id);
	
	int insert(Person person);
	
	int update(Person person);

}
