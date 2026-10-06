package com.bytexl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentApp {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {

            // Create Student object
            Student student = new Student(
                    "Adithya",
                    "adithya@gmail.com",
                    "Artificial Intelligence and Data Science"
            );

            // INSERT student into database
            session.beginTransaction();

            session.persist(student);

            session.getTransaction().commit();

            System.out.println("Student inserted successfully!");
            System.out.println("Inserted Student:");
            System.out.println(student);


            // UPDATE student
            session.beginTransaction();

            student.setCourse("Computer Science and Engineering");

            session.merge(student);

            session.getTransaction().commit();

            System.out.println();
            System.out.println("Student updated successfully!");
            System.out.println("Updated Student:");
            System.out.println(student);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
            factory.close();
        }
    }
}