package test;

import java.sql.Date;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
//			Author author_1 = new Author("001", "Nguyen Nhat Anh", new Date(System.currentTimeMillis()));
//			Book b1 = new Book("B01", "Cho tôi xin một vé đi tuổi thơ", 50000, author_1);
//			Book b2 = new Book("B02", "Tôi thấy hoa vàng trên cỏ xanh", 75000, author_1);
//			Book b3 = new Book("B03", "Tôi là Bêtô", 60000, author_1);
//			
//			session.saveOrUpdate(author_1);
//			session.saveOrUpdate(b1);
//			session.saveOrUpdate(b2);
//			session.saveOrUpdate(b3);
			
//			Author author_2 = new Author("002", "Le Nhat Tung", new Date(System.currentTimeMillis()));
//			Book b3 = new Book("B03", "Lap trinh C", 50000, author_2);
//			Book b4 = new Book("B04", "Lap Trinh Java", 75000, author_2);
//			Book b5 = new Book("B05", "Toan roi rac", 60000, author_2);
//			
//			session.saveOrUpdate(author_2);
//			session.saveOrUpdate(b3);
//			session.saveOrUpdate(b4);
//			session.saveOrUpdate(b5);
			
			Book b1 = session.find(Book.class, "B01");
			System.out.println("Tác giả của sách "+b1.getTitle()+" là "+ b1.getAuthor().getName());
			
			tr.commit();
			session.close();
		}
	}
}
