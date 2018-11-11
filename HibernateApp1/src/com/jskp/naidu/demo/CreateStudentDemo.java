package com.jskp.naidu.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jskp.naidu.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create Session Factory

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		// Session session = factory.openSession();
		Session session = factory.getCurrentSession();
       
		try {
			//create a student object;
			Student tempStudent = new Student("punnana", "janakinaidu",
					"janakinaidu493@gmail.com");
			//start a transaction;
			session.beginTransaction();
			System.out.println("saving the student object");
			//save the student object;
			session.save(tempStudent);
			//commit the transaction;
			session.getTransaction().commit();
			System.out.println("Done");
		} finally{
			session.close();
			factory.close();
		}

	}

}
