package model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class SinhVien extends ConNguoi{
	private double diemTrungBinh;

	public SinhVien() {
		super();
	}

	public SinhVien(String id, String hoVaTen, Date ngaySinh, double diemTrungBinh) {
		super(id, hoVaTen, ngaySinh);
		this.diemTrungBinh = diemTrungBinh;
	}

	public double getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public void setDiemTrungBinh(double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}
	
	
	
}
