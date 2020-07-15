package org.anusha.hibernate;

import java.util.Date;

import org.anusha.dto.Address;
import org.anusha.dto.UserDetails;
import org.anusha.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();

		user.setUserName("Anusha");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);

		

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);

		session.getTransaction().commit();
		session.close();

	}
}
