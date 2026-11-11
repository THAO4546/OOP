package thachDuyThao25735861;

import java.time.LocalDate;

public class TestSanPham {
	public static void main(String[] args) {
		QuanLySanPham ql = new QuanLySanPham();
		
		SanPham sp1 = new SanPhamDienTu("DT01", "Tivi", LocalDate.of(2025, 1, 10), 500000, 10);
		SanPham sp2 = new SanPhamThucPham("TP01", "Cà Rốt", LocalDate.of(2024, 5, 12), 20000, 10);
		SanPham sp3 = new SanPhamDienTu("DT02", "Điện Thoại", LocalDate.of(2025, 9, 10), 1000000, 5);
		SanPham sp4 = new SanPhamDienTu("DT03", "Laptop", LocalDate.of(2026, 1, 10), 3000000, 3);
		SanPham sp5 = new SanPhamThucPham("TP02", "Rau Muống", LocalDate.of(2026, 4, 10), 15000, 15);
		
		System.out.println("Thêm 5 sản phẩm:");
		ql.themSanPham(sp1);
		ql.themSanPham(sp2);
		ql.themSanPham(sp3);
		ql.themSanPham(sp4);
		ql.themSanPham(sp5);
		
		System.out.println("Xuất sản phẩm theo loại (Điện tử)");
		ql.xuatSanPhamTheoLoai("Điện tử ");
		
		System.out.println("Sửa số lượng tồn của Tivi từ 10 lên 13");
		ql.suaSoLuongTon("DT01", 13);
		ql.xuatSanPhamTheoLoai("Điện tử ");
		
		System.out.println("Xuất sản phẩm có giá bán cao nhất");
		ql.xuatSanPhamGiaBanCaoNhat();
		
		System.out.println("Xóa sản phẩm Rau Muống");
		ql.xoaSanPham("TP02");
		ql.getDanhSachSP().forEach(System.out::println);
	}
}
