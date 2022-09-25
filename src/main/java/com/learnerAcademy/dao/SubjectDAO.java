package com.learnerAcademy.dao;

import com.learnerAcademy.domain.Subject;
import com.learnerAcademy.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SubjectDAO {
	public void saveSubject(Subject subject) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.save(subject);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<Subject> list(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 return  (List<Subject>)session.createQuery("FROM Subject").list();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
