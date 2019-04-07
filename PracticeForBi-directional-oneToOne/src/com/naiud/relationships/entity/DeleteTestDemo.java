package com.naiud.relationships.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteTestDemo {

	public static void main(String[] args) {

		// i wanna delete some details;
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class, 6);
			
			System.out.println("Instructor="+tempInstructor);
			System.out.println("Associated instructorDetails="
					+ tempInstructor.getInstructorDetails());
			/*if (tempInstructor != null) {
				session.delete(tempInstructor);
			}*/

			session.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			factory.close();
		}
	}

}
