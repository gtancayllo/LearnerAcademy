package com.learnerAcademy.dao;

import com.learnerAcademy.domain.Teacher;
import com.learnerAcademy.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeacherDAO {
	public void saveTeacher(Teacher teacher) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.save(teacher);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<Teacher> list(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 return  (List<Teacher>)session.createQuery("FROM Teacher").list();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
