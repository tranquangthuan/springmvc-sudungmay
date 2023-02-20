package thuan.com.fa.demomvc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class KhachHang {

	@Id
	private String maKH;

	@Column(name = "tenKH", columnDefinition = "nvarchar(255)")
	private String tenKH;
	@Column(name = "diaChi", columnDefinition = "nvarchar(255)")
	private String diaChi;
	private String soDienThoai;
	private String diaChiEmail;

	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<SuDungDichVu> suDungDichVus;

	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<SuDungMay> suDungmays;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKH, String tenKH, String diaChi, String soDienThoai, String diaChiEmail) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.diaChiEmail = diaChiEmail;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChiEmail() {
		return diaChiEmail;
	}

	public void setDiaChiEmail(String diaChiEmail) {
		this.diaChiEmail = diaChiEmail;
	}

	public Set<SuDungDichVu> getSuDungDichVus() {
		return suDungDichVus;
	}

	public void setSuDungDichVus(Set<SuDungDichVu> suDungDichVus) {
		this.suDungDichVus = suDungDichVus;
	}

	public Set<SuDungMay> getSuDungmays() {
		return suDungmays;
	}

	public void setSuDungmays(Set<SuDungMay> suDungmays) {
		this.suDungmays = suDungmays;
	}

}
