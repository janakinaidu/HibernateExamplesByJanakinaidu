package com.naiud.relationships.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetails {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			InstructorDetails details  = session.get(InstructorDetails.class, 6);
			System.out.println("Instructordetails="+details);
			System.out.println("Associate Instructor="+details.getInstructor());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			factory.close();
		}
		
	}
	
}
