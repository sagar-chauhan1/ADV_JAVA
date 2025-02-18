package ByXMLconfiguration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DemoMain {
	
	public static void main(String args[]) {
		
		Configuration cfg= new Configuration();
		cfg.configure();
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(reg); 
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee(2,"sagar","testing");
		
		session.save(employee);
		
		transaction.commit();
		
		System.out.println("Employee saved successfully");		
		
		
	}

}
