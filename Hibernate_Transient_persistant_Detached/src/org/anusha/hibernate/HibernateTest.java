package org.anusha.hibernate;

import java.util.Date;

import org.anusha.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	public static void main(String[] args) {
		UserDetails user=new UserDetails();
		user.setUserName("Prathyusha");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		user.setUserName("swathi");
		user.setUserName("anu");

		session.getTransaction().commit();
		session.close();
		user.setUserName("akhila");


	}
}