package thuan.com.fa.demomvc.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class SuDungDichVuId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKH;
	private String maDV;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngaySuDung;
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "gioSuDung")
	private LocalTime gioSuDung;

	public SuDungDichVuId() {
		super();
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public LocalDate getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(LocalDate ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public LocalTime getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(LocalTime gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

	public SuDungDichVuId(String maKH, String maDV, LocalDate ngaySuDung, LocalTime gioSuDung) {
		super();
		this.maKH = maKH;
		this.maDV = maDV;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gioSuDung, maDV, maKH, ngaySuDung);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuDungDichVuId other = (SuDungDichVuId) obj;
		return Objects.equals(gioSuDung, other.gioSuDung) && Objects.equals(maDV, other.maDV)
				&& Objects.equals(maKH, other.maKH) && Objects.equals(ngaySuDung, other.ngaySuDung);
	}

}
