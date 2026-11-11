package thachDuyThao25735861;

import java.time.LocalDate;

public abstract class SanPham {
	protected String maSanPham;
	protected String tenSanPham;
	protected LocalDate ngaySanXuat;
	protected Double giaNhap;
	protected int soLuongTonKho;
	
	public SanPham(String maSanPham, String tenSanPham, LocalDate ngaySanXuat, int giaNhap, int soLuongTonKho) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.ngaySanXuat = ngaySanXuat;
		this.giaNhap = (double) giaNhap;
		this.soLuongTonKho = soLuongTonKho;
	}
	public abstract double giaBan();
	public abstract String getLoai();
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}
	public Double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(Double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}
	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}
	@Override
	public String toString() {
		return "SanPham [Mã sản phẩm: " + maSanPham + ", tên sản phẩm: " + tenSanPham + ", ngày sản xuất: " + ngaySanXuat
				+ ", giá nhập: " + giaNhap +" VND" + ", số lượng tồn kho: " + soLuongTonKho + "]";
	}
}