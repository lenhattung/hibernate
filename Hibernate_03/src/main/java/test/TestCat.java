package test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CatDAO;
import model.Cat;
import util.HibernateUtil;

public class TestCat {
	public static void main(String[] args) {
		
		// Transient
		Cat cat_1 = new Cat();
		cat_1.setId(1);
		
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				// Persistent
				cat_1 = session.get(Cat.class, 1);
				
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(cat_1);
		
	}
}
