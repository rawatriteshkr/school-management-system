package com.kipragno.tech.repo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.kipragno.tech.entites.Student;
import com.kipragno.tech.exception.ResourceNotFoundException;

@Repository
public class StudentAuthenticationRepoImpl implements StudentAuthenticationRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String register(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		/*String queryString = "from Student where emailId = :emailId";
		System.out.println(queryString);
		//String emailId = student.getEmailId();
		Query query = session.createQuery(queryString);
		query.setString("emailId", emailId);
		try {
			Student dbStudent = (Student) query.getSingleResult();
				return "409";
		}catch(Exception e) {
			try {
				session.save(student);
				Student dbStudent = (Student) query.getSingleResult();
				if(dbStudent != null) {
					return "Registration No : " + dbStudent.getRegistrationNo();
				}else {
					return "500";
				}
			}catch(Exception ex) {
				ex.printStackTrace();
				return "500";
			}
		}*/
		session.save(student);
		session.save(student.getGuardianContact());
		session.save(student.getGuardianContact().getPermanentAddress());
		session.save(student.getGuardianContact().getMailingAddress());
		session.save(student.getStudentPersonalDetails());
		session.save(student.getStudentPreviousDetails());
		transaction.commit();
		session.close();
		return "done";
		
	}

	
	@Override
	public UserDetails loadUserByUsername(String emailId) {
		/*Session session = sessionFactory.getCurrentSession();
		String queryString = "from Student where emailId = :emailId";
		System.out.println(queryString);
		Query query = session.createQuery(queryString);
		query.setString("emailId", emailId);
		try {
			Student student = (Student) query.getSingleResult();
			return new org.springframework.security.core.userdetails.User(student.getEmailId(), student.getPassword(),
					new ArrayList<>());
		}catch(Exception e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("Incorrect username or password");
		}
		*/
		return null;
		
	}


}
