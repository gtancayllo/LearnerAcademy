package com.learnerAcademy.dao;

import com.learnerAcademy.domain.Student;
import com.learnerAcademy.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(student);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<Student> list(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 return  (List<Student>)session.createQuery("FROM Student").list();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
