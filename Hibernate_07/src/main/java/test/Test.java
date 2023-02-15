package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.CuocHop;
import model.NhanVien;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
			NhanVien nv1 = new NhanVien("NV1", "LNTung", new Date(2000, 10, 15));
			//session.save(nv1);
			
			CuocHop ch1 = new CuocHop();
			ch1.setTenCuocHop("Họp Hội đồng quản trị công ty");
			ch1.setThoiGian(new Date(2025, 2, 28));
			ch1.setDiaDiem("Phòng họp 1");
			ch1.addNhanVien(nv1);
			
			session.save(ch1);
			
			tr.commit();
			session.close();
		}
	}
}
