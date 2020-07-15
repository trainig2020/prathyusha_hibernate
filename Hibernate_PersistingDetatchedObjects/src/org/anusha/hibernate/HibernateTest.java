package org.anusha.hibernate;

import java.util.Date;

import org.anusha.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);

		
		session.getTransaction().commit();
		session.close();
	user.setUserName("Anusha");
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);

		session.getTransaction().commit();
		session.close();

	}
}