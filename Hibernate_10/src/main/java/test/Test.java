package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
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
		
//			DonHang dh1 = new DonHang();
//			dh1.setTenKhachHang("Le Nhat Tung");
//			dh1.setNgayMua(new Date(123, 1, 30));
//			
//			for (int i = 0; i < 10000; i++) {
//				ChiTietDonHang ctdh1 = new ChiTietDonHang();
//				ctdh1.setTenSanPham(i+"");
//				ctdh1.setGiaBan(5000);
//				ctdh1.setSoLuong(5);
//				ctdh1.setThanhTien(5*5000);
//				ctdh1.setDonHang(dh1);
//				dh1.addCTDH(ctdh1);
//			}
			
			
//			session.save(dh1);
			
			
			long batDau = System.currentTimeMillis();
			DonHang dh = session.load(DonHang.class, 1);
			long ketThuc = System.currentTimeMillis();
			System.out.println(dh.toString());
			List<ChiTietDonHang> ds =  dh.getDanhSachChiTiet();
			for (ChiTietDonHang ctdh : ds) {
				System.out.println(ctdh.toString());
			}
			System.out.println("Thời gian thực hiện câu lệnh là: "+ (ketThuc-batDau));
			
			tr.commit();
			session.close();
		}
	}
}
