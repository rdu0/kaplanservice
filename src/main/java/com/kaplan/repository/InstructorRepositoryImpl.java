package com.kaplan.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.kaplan.model.Instructor;

@Repository("instructorRepositoryImpl")
public class InstructorRepositoryImpl implements InstructorRepository {

	@Override
	public void save() {


		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Instructor instructor = new Instructor("aaa", "bbb", 1);
		session.save(instructor);

		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();

	}
	
	public void save(Instructor instructor) {
		

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		
		session.save(instructor);

		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();

	}
}
