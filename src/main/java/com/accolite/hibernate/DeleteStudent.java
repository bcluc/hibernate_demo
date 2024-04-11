package com.accolite.hibernate;

import com.accolite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class DeleteStudent {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {

            int studentId = 1;

            //Start transaction
            session.beginTransaction();

            Query q = session.createQuery("delete from Student where rollNo=:i");
            q.setParameter("i", 1);

            int status = q.executeUpdate();
            System.out.println(status);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Deleted!");
        } finally {
            factory.close();
        }
    }

}
