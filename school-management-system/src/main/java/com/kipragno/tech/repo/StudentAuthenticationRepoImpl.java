package com.kipragno.tech.repo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.kipragno.tech.entites.Student;

@Repository
public class StudentAuthenticationRepoImpl implements StudentAuthenticationRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void register(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
	}

	
	@Override
	public UserDetails loadUserByUsername(String emailId) {
		Session session = sessionFactory.getCurrentSession();
		String queryString = "from Student where emailId = :emailId";
		System.out.println(queryString);
		Query query = session.createQuery(queryString);
		query.setString("emailId", emailId);
		Student student = (Student) query.getSingleResult();
		return new org.springframework.security.core.userdetails.User(student.getEmailId(), student.getPassword(),
				new ArrayList<>());
	}

}
