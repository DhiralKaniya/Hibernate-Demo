package DAO;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Student;

public class StudentDAO {
	
	public StudentDAO() {
	}
	
	public void addStudent(Student student) {
		Transaction transaction = null;
		Integer studentid = null;
		final Session session = HibernatUtils.getHibernateSession();
		try {
			transaction = session.beginTransaction();
			studentid = (Integer) session.save(student);
			transaction.commit();
		}catch(HibernateException e) {
			if(transaction!=null) transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void updateStudent(Student student) {
		Transaction transaction = null;
		final Session session = HibernatUtils.getHibernateSession();
		try{
			transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
		}catch(HibernateException e){
			if(transaction!=null) transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void deleteStudent(Integer studentid) {
		Transaction transaction = null;
		final Session session = HibernatUtils.getHibernateSession();
		try{
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, studentid);
			session.delete(student);
			transaction.commit();
		}catch(HibernateException e){
			if(transaction!=null) transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	public void displayStudent() {
		Transaction transaction = null;
		final Session session = HibernatUtils.getHibernateSession();
		try{
			transaction = session.beginTransaction();
			List<Student> students = session.createQuery("From Student").list();
			for(Student s : students){
				System.out.println("ID -> " + s.getId() + "|| Student Name -> " + s.getStudentName() + "|| Student Age -> " + s.getStudentAge() + "|| Student Contact Number -> "+s.getContactNo());
			}
			transaction.commit();
		}catch(HibernateException e){
			if(transaction!=null) transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
