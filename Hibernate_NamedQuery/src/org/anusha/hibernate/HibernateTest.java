package org.anusha.hibernate;

import java.util.Date;
import java.util.List;

import org.anusha.dto.UserDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "user 10");
		
		List<UserDetails> users = (List<UserDetails>) query.list();
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails user: users)
			System.out.println(user.getUserName());
	}
}