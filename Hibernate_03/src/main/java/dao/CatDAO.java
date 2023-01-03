package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class CatDAO implements DAOInterface<Cat> {

	@Override
	public List<Cat> selectAll() {
		List<Cat> list = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thuc thi cau lenh HQL
				String hql = "from Cat";
				Query query = session.createQuery(hql);
				list = query.getResultList();
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Cat selectById(Cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				Cat result = session.get(Cat.class, 1);
				// find
				// load
				
				tr.commit();
				session.close();
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveOrUpdate(Cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thuc thi cau lenh HQL
				
				// persist(): sẽ không có trả về ID, không báo lỗi khi gặp lỗi
				
				// Chi luu khi chua ton tai
				// session.save(t);
				
				// Them moi khi chua ton tai, cap nhat du lieu khi da ton tai
				session.saveOrUpdate(t);
				
				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean insert(Cat t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Cat t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thuc thi cau lenh HQL
				session.delete(t);
				
				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
