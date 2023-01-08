package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.My_Order;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
//			Customer c1 = new Customer("001", "Le Nhat Tung", "tung@gmail.com");
//			My_Order o1 = new My_Order("1", "Tp HCM", c1);
//			My_Order o2 = new My_Order("2", "Tp HCM", c1);
//			My_Order o3 = new My_Order("3", "Tp HCM", c1);
//			My_Order o4 = new My_Order("4", "Tp HCM", c1);
//			
//			List<My_Order> list = new ArrayList<>();
//			list.add(o1);
//			list.add(o2);
//			list.add(o3);
//			list.add(o4);
//			
//			c1.setOrders(list);
//			
//			session.saveOrUpdate(c1);
//			session.saveOrUpdate(o1);
//			session.saveOrUpdate(o2);
//			session.saveOrUpdate(o3);
//			session.saveOrUpdate(o4);
//			
//			
//			Customer c2 = new Customer("002", "Le Nhat 2", "tung2@gmail.com");
//			session.saveOrUpdate(c2);
			
			
			String hql = "FROM Customer c WHERE size(c.orders) > 0";
			List<Customer> results = session.createQuery(hql).list();
			
			for (Customer rs : results) {
				System.out.println(rs);
			}
			
			tr.commit();
			session.close();
		}
	}
}
