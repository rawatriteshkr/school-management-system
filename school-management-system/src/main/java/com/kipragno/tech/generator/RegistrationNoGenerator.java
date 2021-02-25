package com.kipragno.tech.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RegistrationNoGenerator implements IdentifierGenerator {

	private final String prefix = "SMS";
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		Connection connection = session.connection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(registration_no) from student_details");
			if (rs.next()) {
				int id = rs.getInt(1) + 10001;
				Calendar calendar = new GregorianCalendar();
				int currentYear = calendar.get(Calendar.YEAR);
				String generatedRegistrationNo = prefix + currentYear + new Integer(id).toString();
				System.out.println("Generated Id: " + generatedRegistrationNo);
				return generatedRegistrationNo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
