package com.naiud.relationships.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateTestDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Instructor tempInstructor = new Instructor("p", "janu",
					"janu@gmail.com");
			InstructorDetails tempInstructorDetails = new InstructorDetails(
					"jabardasthChannel", "watchingTv");
			
			tempInstructor.setInstructorDetails(tempInstructorDetails);
			
			//Begin a Transaction
			session.beginTransaction();
			System.out.println("saving tempInstrucotr ="+tempInstructor);
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("done");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			session.close();
			factory.close();
		}
	}
	
}
