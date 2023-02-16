package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ChiTietDonHang;
import model.DonHang;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
		
			DonHang dh1 = new DonHang();
			dh1.setTenKhachHang("Le Nhat Tung");
			dh1.setNgayMua(new Date(123, 1, 30));
			
			ChiTietDonHang ctdh1 = new ChiTietDonHang();
			ctdh1.setTenSanPham("Mì Hảo Hảo");
			ctdh1.setGiaBan(5000);
			ctdh1.setSoLuong(5);
			ctdh1.setThanhTien(5*5000);
			ctdh1.setDonHang(dh1);
			
			
			ChiTietDonHang ctdh2 = new ChiTietDonHang();
			ctdh2.setTenSanPham("Vinamilk");
			ctdh2.setGiaBan(10000);
			ctdh2.setSoLuong(2);
			ctdh2.setThanhTien(2*10000);
			ctdh2.setDonHang(dh1);
			
			dh1.addCTDH(ctdh1);
			dh1.addCTDH(ctdh2);
			
			//session.save(dh1);
			
			
			DonHang dh = session.load(DonHang.class, 1);
			session.remove(dh);
			
			tr.commit();
			session.close();
		}
	}
}
