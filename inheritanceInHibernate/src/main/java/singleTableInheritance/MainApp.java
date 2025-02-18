package singleTableInheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainApp {
	
	public static void main(String args[]) {
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class)
					.addAnnotatedClass(FullTimeEmployee.class).addAnnotatedClass(PartTimeEmployee.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		FullTimeEmployee fullTime = new FullTimeEmployee();
		fullTime.setName("Riky singh");
		fullTime.setSalary(37000);
		fullTime.setBonus(40000);
		
		PartTimeEmployee partTime = new PartTimeEmployee();
		partTime.setName("hardik chauhan");
		partTime.setSalary(43000);
		partTime.setHoursWorked(20);
		
		session.save(fullTime);
		session.save(partTime);
		
		transaction.commit();
		System.out.println("Employee saved successfully!");
		
	}

}
