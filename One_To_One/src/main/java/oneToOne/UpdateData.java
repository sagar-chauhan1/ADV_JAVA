package oneToOne;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {

	public static void main(String args[]) {
		
		SessionFactory factory = new Configuration()
								     .configure("hibernate.cfg.xml")
								     .addAnnotatedClass(Person.class)
								     .addAnnotatedClass(Passport.class)
								     .buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String newName="Ravi";
		long personId=1;
		
		//Use HQL to update the person's name
		String hql = "UPDATE Person p SET p.name = :newName WHERE p.id = :personId";
		Query query = session.createQuery(hql);
		query.setParameter("newName", newName);
		query.setParameter("personId", personId);
		
		//result
		int result = query.executeUpdate();
		
		tx.commit();
		session.close();
		
		System.out.println("Update " + result + "Person(s) with Id: "+ personId);
	}
}
