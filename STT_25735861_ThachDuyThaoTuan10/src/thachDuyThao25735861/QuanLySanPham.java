package thachDuyThao25735861;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLySanPham {
    private List<SanPham> ds;

    public QuanLySanPham() {
        this.ds = new ArrayList<SanPham>();
    }

    public boolean themSanPham(SanPham sp) {
        boolean trungMa = ds.stream().anyMatch(s -> s.getMaSanPham().equalsIgnoreCase(sp.getMaSanPham()));
        if (!trungMa) {
            ds.add(sp);
            return true;
        }
        return false;
    }

    public boolean xoaSanPham(String maSP) {
        return ds.removeIf(s -> s.getMaSanPham().equalsIgnoreCase(maSP));
    }

    public boolean suaSoLuongTon(String maSP, int soLuongMoi) {
        for (SanPham s : ds) {
            if (s.getMaSanPham().equalsIgnoreCase(maSP)) {
                s.setSoLuongTonKho(soLuongMoi);
                return true;
            }
        }
        return false;
    }

    public void xuatSanPhamTheoLoai(String loai) {
        List<SanPham> ketQua = ds.stream()
                .filter(s -> s.getLoai().equalsIgnoreCase(loai))
                .collect(Collectors.toList());
                
        System.out.println("===Danh Sách Sản Phẩm Loại: " + loai + " ===");
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào.");
        } else {
            ketQua.forEach(System.out::println);
        }
    }

    public void xuatSanPhamGiaBanCaoNhat() {
        if (ds.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        
        double maxGia = ds.stream().mapToDouble(SanPham::giaBan).max().orElse(0);
        
        List<SanPham> dsMax = ds.stream()
                .filter(s -> s.giaBan() == maxGia)
                .collect(Collectors.toList());
                
        System.out.println("=== Sản phẩm có giá bán cao nhất: (" + maxGia +")===");
        dsMax.forEach(System.out::println);
    }

    public List<SanPham> getDanhSachSP() {
        return ds;
    }
}
