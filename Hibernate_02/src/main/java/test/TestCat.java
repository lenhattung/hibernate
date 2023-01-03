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
		CatDAO cat_Dao = new CatDAO();

		// Test selectAll();
//		List<Cat> list = cat_Dao.selectAll();
//		for (Cat cat : list) {
//			System.out.println(cat);
//		}

		// Test select by id;
//		Cat c = new Cat();
//		c.setId(1);
//
//		Cat c1 = cat_Dao.selectById(c);
//		System.out.println(c1);
		
		
		// Test insert
		Cat c3 = new Cat("Meo Mum 1", new Date(System.currentTimeMillis()), true);
		c3.setId(3);
		
		
		//cat_Dao.insert(c3);
		
		cat_Dao.delete(c3);
	}
}
