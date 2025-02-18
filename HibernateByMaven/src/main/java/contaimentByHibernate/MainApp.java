package contaimentByHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainApp {
	
	public static void main(String args[]) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Address.class);
		
		ServiceRegistry reg= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		Session session = factory.openSession();
		
		Address address = new Address("ganganagar","pune","sw");
		
		Student student = new Student(102,"sagar","Computer Engineering",address);
		
		Transaction transaction = session.beginTransaction();
		
		session.save(student);
		transaction.commit();
		
		System.out.println("Student saved.....!");
	}
}
