package thachDuyThao25735861;

import java.time.LocalDate;

public class SinhVienChinhQui extends SinhVien {

	public String hocTrucTiep;
	
	public SinhVienChinhQui(String maSV, String hoTen, LocalDate ngaySinh,
			String lop, int soTinChi, MonHoc monHoc, String string) {
		super(maSV, hoTen, ngaySinh, lop, soTinChi, monHoc);
		this.hocTrucTiep = hocTrucTiep;
	}

	public String getHocTrucTiep() {
		return hocTrucTiep;
	}

	public void setHocTrucTiep(String hocTrucTiep) {
		this.hocTrucTiep = hocTrucTiep;
	}
	@Override
	public String getLoai() { return "Chính quy"; }

	@Override
	public String getThongTinRieng() {
	    return "Học trực tiếp tại: " + hocTrucTiep;
	}

	@Override
	public String toString() {
	    return super.toString() + " | " + getThongTinRieng();
	}
	
}
