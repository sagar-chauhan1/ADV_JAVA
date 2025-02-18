package annotationHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class MainApp {
public static void main(String args[]) {
		
		Configuration cfg= new Configuration();
		
		cfg.configure().addAnnotatedClass(Eployee.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(reg); 
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Eployee employee = new Eployee(2,"sagar","testing");
		
		session.save(employee);
		
		transaction.commit();
		
		System.out.println("Employee saved successfully");		
		
		
	}
}
