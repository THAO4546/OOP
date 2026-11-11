package tuan3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham {

    private int id;
    private String maHang;
    private String tenhang;
    private LocalDate NgaySanXuat;
    private LocalDate NgayHetHan;
    private float gia;
    private double donGia;
    private static int demSoLuong = 0;

    public HangThucPham(String maHang, String tenHang, double donGia,
                        LocalDate ngaySanXuat, LocalDate ngayHetHan) {

        if (maHang == null || maHang.trim().isEmpty()) {
            this.maHang = "0000";
        } else {
            this.maHang = maHang;
        }
        if (tenHang == null || tenHang.trim().isEmpty()) {
            this.tenhang = "xxx";
        } else {
            this.tenhang = tenHang;
        }

        if (donGia >= 0) {
            this.donGia = donGia;
        } else {
            this.donGia = 0;
        }

        LocalDate today = LocalDate.now();

        if (ngaySanXuat == null || ngaySanXuat.isAfter(today)) {
            this.NgaySanXuat = today;
        } else {
            this.NgaySanXuat = ngaySanXuat;
        }

        if (ngayHetHan == null ||
            ngayHetHan.isBefore(this.NgaySanXuat)) {

            this.NgayHetHan = this.NgaySanXuat;

        } else {
            this.NgayHetHan = ngayHetHan;
        }

        demSoLuong++;
    }

    public HangThucPham(String maHang) {
        this(maHang, "xxx", 0,
             LocalDate.now(), LocalDate.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        if (tenhang == null || tenhang.trim().isEmpty()) {
            this.tenhang = "xxx";
        } else {
            this.tenhang = tenhang;
        }
    }

    public LocalDate getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {

        LocalDate today = LocalDate.now();

        if (ngaySanXuat == null ||
            ngaySanXuat.isAfter(today)) {

            this.NgaySanXuat = today;

        } else {
            this.NgaySanXuat = ngaySanXuat;
        }

        if (this.NgayHetHan.isBefore(this.NgaySanXuat)) {
            this.NgayHetHan = this.NgaySanXuat;
        }
    }

    public LocalDate getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {

        if (ngayHetHan == null ||
            ngayHetHan.isBefore(this.NgaySanXuat)) {

            this.NgayHetHan = this.NgaySanXuat;

        } else {
            this.NgayHetHan = ngayHetHan;
        }
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public static int getDemSoLuong() {
        return demSoLuong;
    }
    public static void setDemSoLuong(int demSoLuong) {
        HangThucPham.demSoLuong = demSoLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {

        if (donGia >= 0) {
            this.donGia = donGia;
        } else {
            this.donGia = 0;
        }
    }

    public boolean daHetHan() {
        return LocalDate.now().isAfter(NgayHetHan);
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String ghiChu;

        if (daHetHan()) {
            ghiChu = "Hàng hết hạn";
        } else {
            ghiChu = "";
        }

        return String.format(
                "%-10s %-15s %,15.2fVND %-15s %-15s %-15s",
                maHang,
                tenhang,
                donGia,
                NgaySanXuat.format(formatter),
                NgayHetHan.format(formatter),
                ghiChu
        );
    }
    public static void main(String[] args) {

        HangThucPham h1 = new HangThucPham(
                "",
                "Gạo",
                100000,
                LocalDate.now(),
                LocalDate.now()
        );

        HangThucPham h2 = new HangThucPham(
                "002",
                "",
                5000,
                LocalDate.now(),
                LocalDate.now()
        );

        HangThucPham h3 = new HangThucPham(
                "003",
                "Nước",
                -10000,
                LocalDate.now(),
                LocalDate.now()
        );

        HangThucPham h4 = new HangThucPham(
                "004",
                "Sữa",
                20000,
                LocalDate.now().plusDays(10),
                LocalDate.now().plusDays(20)
        );
        
        HangThucPham h5 = new HangThucPham(
                "005",
                "Bánh",
                15000,
                LocalDate.of(2025, 5, 10),
                LocalDate.of(2025, 5, 1)
        );

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
        System.out.println(h5);
    }
}