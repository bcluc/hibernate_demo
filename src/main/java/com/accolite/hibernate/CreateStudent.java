package com.accolite.hibernate;

import com.accolite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudent {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {

            //Create a student object
            System.out.println("Creating student object...");
            Student tempStudent = new Student(5,"Robb", 21);

            //Start transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving student object...");
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Saved!");
        } finally {
            factory.close();
        }
    }

}
