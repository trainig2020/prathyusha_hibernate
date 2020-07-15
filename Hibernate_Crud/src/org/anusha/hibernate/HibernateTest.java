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
		/*for (int i = 0; i < 10; i++) {
			UserDetails user = new UserDetails();
			user.setUserName("user" + i);
			session.save(user);
		}
*/
		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
		//create an elements.....
		//System.out.println("user name pulled up is:" + user.getUserName());
		
		//Delete an element...
	    //session.delete(user);
		
		//update an element...
		user.setUserName("anu");
		session.update(user);
		session.getTransaction().commit();
		session.close();


	}
}