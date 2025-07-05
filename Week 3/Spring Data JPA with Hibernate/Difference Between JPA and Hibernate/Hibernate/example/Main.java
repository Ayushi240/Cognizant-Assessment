package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            // Initialize Hibernate
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();

            // Example CRUD operations

            // CREATE
            Employee newEmp = new Employee();
            newEmp.setName("John Doe");
            Integer id = addEmployee(newEmp);
            System.out.println("Created employee with ID: " + id);

            // READ
            Employee emp = getEmployee(id);
            System.out.println("Retrieved employee: " + emp);

            // UPDATE
            emp.setName("Jane Doe");
            updateEmployee(emp);
            System.out.println("Updated employee: " + getEmployee(id));

            // DELETE
            deleteEmployee(id);
            System.out.println("Employee deleted");

        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public static Integer addEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer id = null;

        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public static Employee getEmployee(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Employee.class, id);
        } finally {
            session.close();
        }
    }

    public static void updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteEmployee(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee emp = session.get(Employee.class, id);
            if (emp != null) {
                session.delete(emp);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
