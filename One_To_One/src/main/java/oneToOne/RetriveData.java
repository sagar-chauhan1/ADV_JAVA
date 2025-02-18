package oneToOne;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RetriveData {
	
	public static void main(String args[]) {
		//create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Person.class)
									 .addAnnotatedClass(Passport.class)
									 .buildSessionFactory();
		
		//Create a session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Use HQL to retrieve all Person instances
		String hql = "SELECT p FROM Person p LEFT JOIN FETCH p.passport";
		Query query = session.createQuery(hql, Person.class);
		
		List<Person> Persons = query.getResultList();
		
		for(Person person : Persons) {
			System.out.println("Person Name: "+ person.getName());
			
			if(person.getPassport() != null) {
				System.out.println("Passport Number: " + person.getPassport().getPassportNumber());
			}else {
				System.out.println("No Passposrt found.");
			}
			System.out.println("---------------------------");
		}
		
		//Commit the transaction and close the session
		tx.commit();
		session.close();
	}
}
