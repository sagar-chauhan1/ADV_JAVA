package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String args[]) {
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Person.class)
									 .addAnnotatedClass(Passport.class)
									 .buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Passport pass = new Passport();
		pass.setPassportNumber("M73838");
		
		Person per = new Person();
		per.setName("John Vic");
		per.setPassport(pass);
		
		session.save(per);
		
		tx.commit();
		System.out.println("Person and Passport saved!");
	}
}
