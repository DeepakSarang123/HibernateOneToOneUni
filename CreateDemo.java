package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create Sessionfactory and Session 
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Instructor.class).
				                 addAnnotatedClass(InstructorDetail.class).
				                 buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			//create the objects
			Instructor tempInstructor = new
					    Instructor("Deepak","Sarang","deepak@gmail.com");
			
			InstructorDetail tempInstructorDetail = new
					    InstructorDetail("https://www.youtube.com","Trekking");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start transaction
			session.beginTransaction();
			
			//save objects
			System.out.println("Saving instructor:" + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			
			
			
		}finally {
			factory.close();
		}
	}

}
