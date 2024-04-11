package com.accolite.hibernate;

import com.accolite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateStudent {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

            Query q = session.createQuery("update Student set studentName=:n where rollNo=:i");
            q.setParameter("n", "Bran");
            q.setParameter("i", 1);

            int status = q.executeUpdate();
            System.out.println(status);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Updated!");
        } finally {
            factory.close();
        }
    }

}
