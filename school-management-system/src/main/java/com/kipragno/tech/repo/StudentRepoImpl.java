package com.kipragno.tech.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kipragno.tech.entites.Student;

@Repository
public class StudentRepoImpl implements StudentRepo{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Student retreiveStudentById(Long registrationNo) {
		Session session = sessionFactory.getCurrentSession();
		String queryString = "from Student where registrationNo = :registrationNo";
		System.out.println(queryString);
		Query query = session.createQuery(queryString);
		query.setLong("registrationNo", registrationNo);
		Student student = (Student) query.getSingleResult();
		return student;
	}
	
}
