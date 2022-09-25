package com.learnerAcademy.dao;

import com.learnerAcademy.domain.Classroom;
import com.learnerAcademy.domain.ClassroomSubject;
import com.learnerAcademy.domain.Subject;
import com.learnerAcademy.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClassroomDAO {
	public void saveClassroom(Classroom classroom) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.save(classroom);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<Classroom> list(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 return  (List<Classroom>)session.createQuery("FROM Classroom").list();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ClassroomSubject> listClassroomSubjects(int classroomId)
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "FROM ClassroomSubject as CS WHERE CS.classroom.id = :classroomId";
			return (List<ClassroomSubject>)session.createQuery(hql)
			.setParameter("classroomId",classroomId).list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public void assignSubjects(Integer classroomId, List<Integer> subjectIds) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Classroom classroom = session.get(Classroom.class, 1);
			
			transaction = session.beginTransaction();
			
			String hql = "delete from ClassroomSubject as s where s.classroom.id = :classroomId";
			session.createQuery(hql).setInteger("classroomId",classroomId).executeUpdate();
			
			for(Integer subjectId : subjectIds)
			{
				Subject subject = session.get(Subject.class, subjectId);
				ClassroomSubject classroomSubject = new ClassroomSubject();
				classroomSubject.setClassroom(classroom);
				classroomSubject.setSubject(subject);
				session.save(classroomSubject);	
			}
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	/*public void assignSubjects(Integer classroomId, List<String> subjectsToRemove, List<String> subjectsToAdd)
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Classroom classroom = session.get(Classroom.class, classroomId);
			
			Subject subject = session.get(Subject.class, classroom)
			ClassroomSubject classroomSubject = new ClassroomSubject();
			classroomSubject.setClassroom(classroom);
			classroomSubject.setSubject();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}*/
	
}
