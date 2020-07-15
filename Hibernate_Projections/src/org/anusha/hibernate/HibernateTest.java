package org.anusha.hibernate;

import java.util.List;

import org.anusha.dto.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

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
		UserDetails exampleUser= new UserDetails();
		exampleUser.setUserId(5);
		exampleUser.setUserName("user 5");
		
		Example example= Example.create(exampleUser);//.excludeProperty("userName");
		
		Criteria criteria=session.createCriteria(UserDetails.class).add(example);
		List<UserDetails> users = (List<UserDetails>) criteria.list();
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails user: users)
			System.out.println(user.getUserName());
	}
}