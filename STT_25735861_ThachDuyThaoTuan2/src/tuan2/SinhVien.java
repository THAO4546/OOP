package tuan2;

import java.util.Scanner;

public class SinhVien {

    private int maSinhVien;
    private String hoTen;
    private double diemLT;
    private double diemTH;

    public SinhVien() {
        maSinhVien = 0;
        hoTen = "Chua co";
        diemLT = 0.0;
        diemTH = 0.0;
    }

    public SinhVien(int maSinhVien, String hoTen, double diemLT, double diemTH) {
        setMaSinhVien(maSinhVien);
        setHoTen(hoTen);
        setDiemLT(diemLT);
        setDiemTH(diemTH);
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        if (maSinhVien > 0) {
            this.maSinhVien = maSinhVien;
        } else {
            this.maSinhVien = 0;
        }
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        if (hoTen != null && !hoTen.trim().isEmpty()) {
            this.hoTen = hoTen;
        } else {
            this.hoTen = "Chưa xác định";
        }
    }

    public double getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(double diemLT) {
        if (diemLT >= 0.0 && diemLT <= 10.0) {
            this.diemLT = diemLT;
        } else {
            this.diemLT = 0.0;
        }
    }

    public double getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(double diemTH) {
        if (diemTH >= 0.0 && diemTH <= 10.0) {
            this.diemTH = diemTH;
        } else {
            this.diemTH = 0.0;
        }
    }

    public double tinhDiemTB() {
        return (diemLT + diemTH) / 2;
    }

    @Override
    public String toString() {
        return String.format(
            "%-10d %-25s %-10.2f %-10.2f %-10.2f",
            maSinhVien,
            hoTen,
            diemLT,
            diemTH,
            tinhDiemTB()
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SinhVien sv1 = new SinhVien(
            11111,
            "Nguyễn Thanh An",
            6.5,
            8.5
        );

        SinhVien sv2 = new SinhVien(
            22222,
            "Trần Thị Bông",
            7.5,
            8.0
        );

        SinhVien sv3 = new SinhVien();

        System.out.print("Nhập mã số của sinh viên sv3:\n");
        int ma = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập họ và tên của sinh viên sv3:\n");
        String hoTen = sc.nextLine();

        System.out.print("Nhập điểm lý thuyết của sinh viên sv3:\n");
        double diemLT = sc.nextDouble();

        System.out.print("Nhập điểm thực hành của sinh viên sv3:\n");
        double diemTH = sc.nextDouble();

        sv3.setMaSinhVien(ma);
        sv3.setHoTen(hoTen);
        sv3.setDiemLT(diemLT);
        sv3.setDiemTH(diemTH);

        System.out.printf(
            "%-10s %-25s %-10s %-10s %-10s%n",
            "mssv",
            "hoten",
            "diemlt",
            "diemth",
            "diemtb"
        );

        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);

        sc.close();
    }
}