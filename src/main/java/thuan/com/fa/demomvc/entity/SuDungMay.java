package thuan.com.fa.demomvc.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class SuDungMay {

	@EmbeddedId
	private SuDungMayId id;

	@JoinColumn(name = "maMay")
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maMay")
	private May may;

	@JoinColumn(name = "maKH", referencedColumnName = "maKH")
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maKH")
	private KhachHang khachHang;

	private int thoiGianSuDung;

	public SuDungMay() {
		super();
	}

	public SuDungMay(SuDungMayId id, May may, KhachHang khachHang, int thoiGianSuDung) {
		super();
		this.id = id;
		this.may = may;
		this.khachHang = khachHang;
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public SuDungMayId getId() {
		return id;
	}

	public void setId(SuDungMayId id) {
		this.id = id;
	}

	public May getMay() {
		return may;
	}

	public void setMay(May may) {
		this.may = may;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public int getThoiGianSuDung() {
		return thoiGianSuDung;
	}

	public void setThoiGianSuDung(int thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}
}
