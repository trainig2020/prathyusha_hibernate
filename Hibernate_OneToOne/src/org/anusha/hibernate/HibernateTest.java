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

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		user.setVehicle(vehicle);

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);

		session.getTransaction().commit();
		session.close();

	}
}
