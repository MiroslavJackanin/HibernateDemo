package sk.itsovy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.hibernate.entity.Student;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session;

        try{
            int studentId = 1;
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Student student = session.get(Student.class, studentId);
            //session.delete(student);

            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            sessionFactory.close();
        }
    }
}
