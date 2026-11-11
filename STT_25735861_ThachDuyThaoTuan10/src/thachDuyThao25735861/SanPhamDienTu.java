package thachDuyThao25735861;

import java.time.LocalDate;

public class SanPhamDienTu extends SanPham {
	private int thoiGianBaoHanh;
	
	public SanPhamDienTu(String maSanPham, String tenSanPham, LocalDate ngaySanXuat, int giaNhap,
			int soLuongTonKho) {
		super(maSanPham, tenSanPham, ngaySanXuat, giaNhap, soLuongTonKho);
	}

	@Override
	public double giaBan() {
		return giaNhap + (giaNhap * 0.10) + (thoiGianBaoHanh * 50000);
	}

	@Override
	public String getLoai() {
		return "Điện tử ";
	}

	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}	
}