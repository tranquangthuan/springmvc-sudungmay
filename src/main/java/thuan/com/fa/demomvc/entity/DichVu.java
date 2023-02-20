package thuan.com.fa.demomvc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DichVu {

	@Id
	private String maDV;

	@Column(name = "tenDV", columnDefinition = "nvarchar(255)")
	private String tenDV;
	@Column(name = "donViTinh", columnDefinition = "nvarchar(255)")
	private String donViTinh;
	private Double donGia;

	@OneToMany(mappedBy = "dichVu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<SuDungDichVu> dungDichVus;

	public DichVu() {
		super();
	}

	public DichVu(String maDV, String tenDV, String donViTinh, Double donGia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	public Set<SuDungDichVu> getDungDichVus() {
		return dungDichVus;
	}

	public void setDungDichVus(Set<SuDungDichVu> dungDichVus) {
		this.dungDichVus = dungDichVus;
	}

}
