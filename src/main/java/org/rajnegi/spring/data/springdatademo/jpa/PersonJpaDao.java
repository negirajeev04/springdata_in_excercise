package org.rajnegi.spring.data.springdatademo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.rajnegi.spring.data.springdatademo.entity.Person;
import org.rajnegi.spring.data.springdatademo.jdbc.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@Qualifier("jpaDao")
public class PersonJpaDao implements IPersonDao {

	@Autowired
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}

	@Override
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	@Override
	public List<Person> findByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
		return 0;
	}

	@Override
	public int insert(Person person) {
		entityManager.merge(person);
		return 1;
	}

	@Override
	public int update(Person person) {
		entityManager.merge(person);
		return 1;
	}

}
