package org.anusha.hibernate;

import java.util.Date;

import org.anusha.dto.Address;
import org.anusha.dto.FourWheeler;
import org.anusha.dto.TwoWheeler;
import org.anusha.dto.UserDetails;
import org.anusha.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Streering Handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("porsche");
		car.setSteeringWheel("porsche Streering Wheel");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);

		session.getTransaction().commit();
		session.close();

	}
}
