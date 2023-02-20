package thuan.com.fa.demomvc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class May {

	@Id
	private String maMay;

	@Column(name = "viTri", columnDefinition = "nvarchar(255)")
	private String viTri;

	@Column(name = "trangThai", columnDefinition = "nvarchar(255)")
	private String trangThai;

	@OneToMany(mappedBy = "may", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<SuDungMay> suDungmays;

	public May() {
		super();
		// TODO Auto-generated constructor stub
	}

	public May(String maMay, String viTri, String trangThai) {
		super();
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Set<SuDungMay> getSuDungmays() {
		return suDungmays;
	}

	public void setSuDungmays(Set<SuDungMay> suDungmays) {
		this.suDungmays = suDungmays;
	}

}
