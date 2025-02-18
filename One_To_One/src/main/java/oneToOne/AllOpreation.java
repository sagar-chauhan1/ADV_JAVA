package oneToOne;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AllOpreation {
	public static void main(String[] args) {
		 // Create session factory
      SessionFactory factory = new Configuration()
                                  .configure("hibernate.cfg.xml")
                                  .addAnnotatedClass(Person.class)
                                  .addAnnotatedClass(Passport.class)
                                  .buildSessionFactory();
      
      Scanner sc=new Scanner(System.in);
      Boolean flag=true;
      
      do {
      System.out.println("Choise Following Options :"
      		+ "\n1.Add New Data"
      		+ "\n2.Update Person Name"
      		+ "\n3.Update Person Passport No."
      		+ "\n4.Delete Data "
      		+ "\n5.Display Data"
      		+ "\n6.Exit");
      int op=sc.nextInt();
      if(op==1) {
   	   System.out.println("Enter Name :");
   	   String name=sc.next();
   	   System.out.println("Enter Passport No.");
   	   String passport=sc.next();
   	   savePersonWithPassport(factory,name,passport);
      }else if(op==2) {
   	   System.out.println("Enter Person Id :");
   	   long id=sc.nextLong();
   	   System.out.println("Enter New Name :");
   	   String newName=sc.next();
   	   updatePersonName(factory, id,newName);
      }else if(op==3) {
   	   System.out.println("Enter Person Id :");
   	   long id=sc.nextLong();
   	   System.out.println("Enter Passport No.");
   	   String NewPassportNo=sc.next();
   	   updatePassportNumber(factory, id, NewPassportNo);
      }else if(op==4) {
   	   System.out.println("Enter Person Id :");
   	   long id=sc.nextLong();
   	  
      }else if(op==5) {
   	   retrieveAllPersonsWithPassports(factory);
      }else if(op==6) {
   	   flag=false;
      }
     
	}while(flag==true);
      
  }
	
	// Method to save a person with passport
   private static void savePersonWithPassport(SessionFactory factory,String name,String passportNo) {
       Session session = factory.openSession();
       Transaction tx = session.beginTransaction();

       Passport passport = new Passport();
       passport.setPassportNumber(passportNo);

       Person person = new Person();
       person.setName(name);
       person.setPassport(passport);

       session.save(person);
       tx.commit();
       session.close();
       System.out.println("Person and Passport saved!");
   }

	
	 // Method to update person's name based on their ID
   private static void updatePersonName(SessionFactory factory, long personId, String newName) {
       Session session = factory.openSession();
       Transaction tx = session.beginTransaction();

       // Use HQL to update the person’s name
       String hql = "UPDATE Person p SET p.name = :newName WHERE p.id = :personId";
       Query query = session.createQuery(hql);
       query.setParameter("newName", newName);
       query.setParameter("personId", personId);

       int result = query.executeUpdate();
       tx.commit();
       session.close();

       System.out.println("Updated " + result + " person(s) with ID: " + personId);
   }

   // Method to update passport number based on person's ID
   private static void updatePassportNumber(SessionFactory factory, long personId, String newPassportNumber) {
       Session session = factory.openSession();
       Transaction tx = session.beginTransaction();

       // Use HQL to update the passport number
       String hql = "UPDATE Passport p SET p.passportNumber = :newPassportNumber WHERE p.id = (SELECT person.passport.id FROM Person person WHERE person.id = :personId)";
       Query query = session.createQuery(hql);
       query.setParameter("newPassportNumber", newPassportNumber);
       query.setParameter("personId", personId);

       int result = query.executeUpdate();
       tx.commit();
       session.close();

       System.out.println("Updated " + result + " passport(s) for Person ID: " + personId);
   }

   private static void retrieveAllPersonsWithPassports(SessionFactory factory) {
       Session session = factory.openSession();
       Transaction tx = session.beginTransaction();

       // Use HQL to retrieve all Person instances with their passports
       String hql = "SELECT p FROM Person p LEFT JOIN FETCH p.passport";
       Query query = session.createQuery(hql, Person.class);
       List<Person> persons = query.getResultList();

       // Display the results
       for (Person person : persons) {
           System.out.println("Person Name: " + person.getName());
           if (person.getPassport() != null) {
               System.out.println("Passport Number: " + person.getPassport().getPassportNumber());
           } else {
               System.out.println("No Passport found.");
           }
           System.out.println("-------------------------");
       }

       // Commit the transaction and close the session
       tx.commit();
       session.close();
   }
   

}

