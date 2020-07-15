package org.anusha.hibernate;

import java.util.Date;

import org.anusha.dto.Address;
import org.anusha.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		/*
		 * user.setUserId(1);
		 */user.setUserName("Anusha");
		 

		Address addr= new Address();
		addr.setStreet("GAR colony");
		addr.setCity("giddalur");
		user.setHomeAddress(addr);
		
		Address addr2= new Address();
		addr2.setStreet("BTM");
		addr2.setCity("Banglore");
		user.setOfficeAddress(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);

		session.getTransaction().commit();
		session.close();

	}
}
