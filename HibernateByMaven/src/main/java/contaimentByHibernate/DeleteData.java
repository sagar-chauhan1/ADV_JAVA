package contaimentByHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DeleteData {
	
	public static void main(String args[]) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Address.class);
		
		ServiceRegistry reg= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		int studentId = 1;
		Student student = session.get(Student.class,studentId);
		
		if(student != null) {
			
			System.out.println("Delete student: "+ student);
			session.delete(student);
			
			transaction.commit();
			
		}else {
			System.out.println("Student not found with Id: "+ studentId);
		}
		
		session.close();
		factory.close();
		}
}
