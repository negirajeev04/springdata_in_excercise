package org.rajnegi.spring.data.springdatademo.springdata;

import org.rajnegi.spring.data.springdatademo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringDataRepository extends JpaRepository<Person, Integer>{

}
