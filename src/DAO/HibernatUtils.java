package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatUtils {
	public static Session getHibernateSession() {
		final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		final Session session = sessionFactory.openSession();
		return session;
	}
}
