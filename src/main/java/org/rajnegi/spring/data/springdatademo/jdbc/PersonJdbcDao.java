package org.rajnegi.spring.data.springdatademo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.rajnegi.spring.data.springdatademo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jdbcDao")
public class PersonJdbcDao implements IPersonDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person",
				new PersonRowMapper());
	}

	@Override
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {10001}, new PersonRowMapper());
	}

	@Override
	public List<Person> findByLocation(String location) {
		return jdbcTemplate.query("select * from person where location=?", new Object[] {location}, new PersonRowMapper());
	}

	@Override
	public Person findByName(String name) {
		return jdbcTemplate.queryForObject("select * from person where name=?", new Object[] {name}, new PersonRowMapper());
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id = ?", new Object[] {id});
	}

	@Override
	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) values (?,?,?,?)"
				, person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()));
	}

	@Override
	public int update(Person person) {
		return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ?"
				+ " where id= ?", person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId());
	}

	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			
			return person;
		}
		
	}
	
}
