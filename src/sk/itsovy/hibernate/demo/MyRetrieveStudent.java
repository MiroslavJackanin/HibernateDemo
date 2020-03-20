package sk.itsovy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.hibernate.entity.Student;

public class MyRetrieveStudent {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Student student;
        try{
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            student = session.get(Student.class, 1);

            System.out.println(student.toString());

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
