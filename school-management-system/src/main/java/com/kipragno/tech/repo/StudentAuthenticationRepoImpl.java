package com.kipragno.tech.repo;

import java.util.ArrayList;

import javax.mail.MessagingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.kipragno.tech.entites.Student;
import com.kipragno.tech.entites.StudentCredentials;
import com.kipragno.tech.exception.ResourceNotFoundException;
import com.kipragno.tech.mail.MailUtil;

@Repository
public class StudentAuthenticationRepoImpl implements StudentAuthenticationRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String register(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String email = student.getStudentCredentials().getEmail();
		String queryString = "from StudentCredentials where email = :email";
		System.out.println(queryString);
		Query query = session.createQuery(queryString);
		query.setString("email", email);
		try {
			StudentCredentials studentCredentials = (StudentCredentials) query.getSingleResult();
				return "409";
		}catch(Exception e) {
			try {
				session.save(student.getGuardianContact());
				session.save(student.getGuardianContact().getPermanentAddress());
				session.save(student.getGuardianContact().getMailingAddress());
				session.save(student.getStudentCredentials());
				session.save(student.getStudentPersonalDetails());
				session.save(student.getStudentPreviousDetails());
				session.save(student);
				transaction.commit();
				session.close();
				return student.getRegistrationNo();
			}catch(Exception ex) {
				ex.printStackTrace();
				return "500";
			}
		}
		
	}

	
	@Override
	public UserDetails loadUserByUsername(String registrationNo) {
		Session session = sessionFactory.getCurrentSession();
		String queryString = "from Student where registrationNo = :registrationNo";
		System.out.println(queryString);
		Query query = session.createQuery(queryString);
		query.setString("registrationNo", registrationNo);
		try {
			Student student = (Student) query.getSingleResult();
			return new org.springframework.security.core.userdetails.User(student.getRegistrationNo(), student.getStudentCredentials().getPassword(),
					new ArrayList<>());
		}catch(Exception e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("Incorrect username or password");
		}
		
	}


}
