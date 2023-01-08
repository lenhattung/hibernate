package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class Test2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
			String hql = "SELECT p.id, p.name, p.spouse.id, p.spouse.name FROM Person p";
			List<Object[]> results = session.createQuery(hql).list();
			
			for (Object[] rs : results) {
				String id = rs[0]+"";
				String name = rs[1]+"";
				String spouseId = rs[2]+"";
				String spouseName = rs[3]+"";
				
				System.out.println(name +"("+id+")" + " đã kết hôn với " + spouseName+"("+spouseId+")");
			}
			
			tr.commit();
			session.close();
		}
	}
}
