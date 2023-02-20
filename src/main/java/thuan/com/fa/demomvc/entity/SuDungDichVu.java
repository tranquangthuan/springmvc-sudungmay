package thuan.com.fa.demomvc.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class SuDungDichVu {

	@EmbeddedId
	private SuDungDichVuId id;

	@JoinColumn(name = "maDV")
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maDV")
	private DichVu dichVu;

	@JoinColumn(name = "maKH")
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maKH")
	private KhachHang khachHang;

	private int soLuong;

	public SuDungDichVu() {
		super();
	}

	public SuDungDichVu(SuDungDichVuId id, DichVu dichVu, KhachHang khachHang, int soLuong) {
		super();
		this.id = id;
		this.dichVu = dichVu;
		this.khachHang = khachHang;
		this.soLuong = soLuong;
	}

	public SuDungDichVuId getId() {
		return id;
	}

	public void setId(SuDungDichVuId id) {
		this.id = id;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}
