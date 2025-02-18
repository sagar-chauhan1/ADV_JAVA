package inheritanceTablePerClass;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String args[]) {
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Vehicle.class)
				.addAnnotatedClass(Car.class).addAnnotatedClass(Bike.class);
		
		StandardServiceRegistry reg = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties())
				.build();
		
		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Car car = new Car();
		car.setBrand("Toyata");
		car.setNumberOfDoors(4);
		
		Bike bike = new Bike();
		bike.setBrand("Horley Devidson");
		bike.setBikeType("Cruiser");
		 
		session.persist(car);
		session.persist(bike);
		
		session.getTransaction().commit();
		
		System.out.println("Data saved successfully!");
		
		session.close();
		factory.close();
		
		
	}
}
