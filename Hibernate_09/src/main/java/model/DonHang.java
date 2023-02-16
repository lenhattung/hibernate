package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class DonHang {
	@Id
	@GeneratedValue
	private int id;
	private String tenKhachHang;
	private Date ngayMua;
	
	@OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.MERGE)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.PERSIST)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.REMOVE)
	private List<ChiTietDonHang> danhSachChiTiet = new ArrayList<ChiTietDonHang>();

	public DonHang() {
	}

	public DonHang(int id, String tenKhachHang, Date ngayMua, List<ChiTietDonHang> danhSachChiTiet) {
		this.id = id;
		this.tenKhachHang = tenKhachHang;
		this.ngayMua = ngayMua;
		this.danhSachChiTiet = danhSachChiTiet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public List<ChiTietDonHang> getDanhSachChiTiet() {
		return danhSachChiTiet;
	}

	public void setDanhSachChiTiet(List<ChiTietDonHang> danhSachChiTiet) {
		this.danhSachChiTiet = danhSachChiTiet;
	}
	
	public void addCTDH(ChiTietDonHang ctdh) {
		this.danhSachChiTiet.add(ctdh);
	}
}
