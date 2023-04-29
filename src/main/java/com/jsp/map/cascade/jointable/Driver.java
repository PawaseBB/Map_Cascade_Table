package com.jsp.map.cascade.jointable;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("bhushan");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student1=new Student();
		student1.setName("Bhushan");
		student1.setEmail("bhushan@gmail.com");
		

		Student student2=new Student();
		student2.setName("Ram");
		student2.setEmail("ram@gmail.com");
		
		
		Courses courses1=new Courses();
		courses1.setName("java");
		courses1.setDuration(60);
		
		Courses courses2=new Courses();
		courses2.setName("SQL");
		courses2.setDuration(40);
		
		Courses courses3=new Courses();
		courses3.setName("HTML");
		courses3.setDuration(30);
		
		ArrayList<Courses> courses=new ArrayList<Courses>();
		
		courses.add(courses1);
		courses.add(courses2);
		courses.add(courses3);
		
		ArrayList<Student> students=new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		
		student1.setCourses(courses);
		student2.setCourses(courses);
		
		courses1.setStudent(students);
		courses2.setStudent(students);
		courses3.setStudent(students);
		
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(courses1);
		entityManager.persist(courses2);
		entityManager.persist(courses3);
		
		entityTransaction.commit();
	}
}


