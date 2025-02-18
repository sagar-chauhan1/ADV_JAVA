package ByXMLconfiguration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class DemoMain2 {
	
	public static void main(String args[]) {
	
	Configuration cfg = new Configuration();
	
	cfg.configure();
	
	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	
	SessionFactory factory = cfg.buildSessionFactory(reg);
	
	Session session = factory.openSession();
	Transaction transaction = session.beginTransaction();
	
	Employee employee = (Employee) session.get(Employee.class,1);
	
	if(employee != null) {
		System.out.println("Id:  "+ employee.getId());
		System.out.println("Name:  "+ employee.getName());
		System.out.println("Department:  "+ employee.getDepartment());
	}else {
		System.out.println("Employee not found.");
	}
	
	transaction.commit();
	session.close();
	
	}
}
