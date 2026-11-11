package thachDuyThao25735861;

import java.time.LocalDate;

public class SanPhamThucPham extends SanPham {
	private int thoiGianHetHan;
	public SanPhamThucPham(String maSanPham, String tenSanPham, LocalDate ngaySanXuat, int giaNhap,
			int soLuongTonKho) {
		super(maSanPham, tenSanPham, ngaySanXuat, giaNhap, soLuongTonKho);
	}

	@Override
	public double giaBan() {
		return giaNhap + (giaNhap * 0.05);
	}

	@Override
	public String getLoai() {
		return "Thực phẩm";
	}
	public int getThoiGianHetHan() {
		return thoiGianHetHan;
	}
}