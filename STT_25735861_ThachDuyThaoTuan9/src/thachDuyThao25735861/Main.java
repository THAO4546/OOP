package thachDuyThao25735861;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ListPhongHoc ds = new ListPhongHoc();

    // Nhap chuoi
    public static String nhapChuoi(String thongBao) {
        System.out.print(thongBao);
        return sc.nextLine().trim();
    }

    // Nhap so nguyen
    public static int nhapInt(String thongBao) {
        while (true) {
            try {
                System.out.print(thongBao);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
            }
        }
    }

    // Nhap so nguyen khong am
    public static int nhapIntKhongAm(String thongBao) {
        int n;
        do {
            n = nhapInt(thongBao);
            if (n < 0) {
                System.out.println("Gia tri phai >= 0!");
            }
        } while (n < 0);
        return n;
    }

    // Nhap dien tich
    public static float nhapDienTich() {
        while (true) {
            try {
                System.out.print("Nhap dien tich: ");
                float dt = Float.parseFloat(sc.nextLine().trim());

                if (Float.isFinite(dt) && dt > 0) {
                    return dt;
                }

                System.out.println("Dien tich phai lon hon 0!");
            } catch (NumberFormatException e) {
                System.out.println("Dien tich khong hop le!");
            }
        }
    }

    // Nhap boolean bang Y/N
    public static boolean nhapCoKhong(String thongBao) {
        while (true) {
            String s = nhapChuoi(thongBao + " (Y/N): ");

            if (s.equalsIgnoreCase("Y")) {
                return true;
            } else if (s.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println("Chi nhap Y hoac N!");
        }
    }

    // Nhap thong tin phong hoc
    public static PhongHoc nhapPhong() {
        System.out.println("\n--- CHON LOAI PHONG ---");
        System.out.println("1. Phong ly thuyet");
        System.out.println("2. Phong may tinh");
        System.out.println("3. Phong thi nghiem");

        int loai;
        do {
            loai = nhapInt("Chon loai phong: ");
            if (loai < 1 || loai > 3) {
                System.out.println("Vui long chon tu 1 den 3!");
            }
        } while (loai < 1 || loai > 3);

        String ma = nhapChuoi("Nhap ma phong: ");
        String day = nhapChuoi("Nhap day nha: ");
        float dienTich = nhapDienTich();
        int soDen = nhapIntKhongAm("Nhap so bong den: ");

        switch (loai) {
            case 1:
                boolean mayChieu =
                        nhapCoKhong("Phong co may chieu khong");
                return new PhongHocLT(
                        ma, day, dienTich, soDen, mayChieu
                );

            case 2:
                int soMay = nhapIntKhongAm("Nhap so may tinh: ");
                return new PhongHocMayTinh(
                        ma, day, dienTich, soDen, soMay
                );

            case 3:
                String chuyenNganh =
                        nhapChuoi("Nhap chuyen nganh: ");
                int sucChua =
                        nhapIntKhongAm("Nhap suc chua: ");
                boolean bonRua =
                        nhapCoKhong("Phong co bon rua khong");

                return new PhongHocThiNghiem(
                        ma, day, dienTich, soDen,
                        chuyenNganh, sucChua, bonRua
                );

            default:
                return null;
        }
    }

    // 1. Them phong
    public static void themPhong() {
        PhongHoc p = nhapPhong();

        if (ds.themPhong(p)) {
            System.out.println("Them phong thanh cong!");
        } else {
            System.out.println(
                    "Them that bai! Ma phong bi trung hoac khong hop le."
            );
        }
    }

    // 2. Tim phong
    public static void timPhong() {
        String ma = nhapChuoi("Nhap ma phong can tim: ");
        PhongHoc p = ds.timPhong(ma);

        if (p == null) {
            System.out.println("Khong tim thay phong!");
        } else {
            System.out.println(p);
        }
    }

    // 3. Cap nhat so may tinh
    public static void capNhatSoMayTinh() {
        String ma = nhapChuoi("Nhap ma phong may tinh: ");
        PhongHoc p = ds.timPhong(ma);

        if (p == null) {
            System.out.println("Khong tim thay phong!");
            return;
        }

        if (!(p instanceof PhongHocMayTinh)) {
            System.out.println("Day khong phai phong may tinh!");
            return;
        }

        int soMay = nhapIntKhongAm("Nhap so may tinh moi: ");

        if (ds.capNhatSoMayTinh(ma, soMay)) {
            System.out.println("Cap nhat thanh cong!");
            System.out.println(ds.timPhong(ma));
        } else {
            System.out.println("Cap nhat that bai!");
        }
    }

    // 4. Xoa phong co xac nhan
    public static void xoaPhong() {
        String ma = nhapChuoi("Nhap ma phong can xoa: ");
        PhongHoc p = ds.timPhong(ma);

        if (p == null) {
            System.out.println("Khong tim thay phong!");
            return;
        }

        System.out.println("Thong tin phong can xoa:");
        System.out.println(p);

        boolean xacNhan = nhapCoKhong(
                "Ban co chac chan muon xoa phong nay khong"
        );

        if (xacNhan) {
            if (ds.xoaPhong(ma)) {
                System.out.println("Xoa phong thanh cong!");
            } else {
                System.out.println("Xoa phong that bai!");
            }
        } else {
            System.out.println("Da huy thao tac xoa.");
        }
    }

    // Menu chinh
    public static void menu() {
        int chon;

        do {
            System.out.println("\n========== QUAN LY PHONG HOC ==========");
            System.out.println("1. Them phong hoc");
            System.out.println("2. Tim phong theo ma");
            System.out.println("3. Xuat danh sach phong hoc");
            System.out.println("4. Xuat danh sach phong dat chuan");
            System.out.println("5. Sap xep tang dan theo day nha");
            System.out.println("6. Sap xep giam dan theo dien tich");
            System.out.println("7. Sap xep tang dan theo so bong den");
            System.out.println("8. Cap nhat so may tinh");
            System.out.println("9. Xoa phong hoc");
            System.out.println("10. Tinh tong so phong");
            System.out.println("11. Tim phong may co 60 may");
            System.out.println("0. Thoat");
            System.out.println("========================================");

            chon = nhapInt("Nhap lua chon: ");

            switch (chon) {
                case 1:
                    themPhong();
                    break;

                case 2:
                    timPhong();
                    break;

                case 3:
                    ds.xuatDanhSach();
                    break;

                case 4:
                    ds.xuatPhongDatChuan();
                    break;

                case 5:
                    ds.sapXepTheoDayNha();
                    System.out.println("Da sap xep theo day nha!");
                    ds.xuatDanhSach();
                    break;

                case 6:
                    ds.sapXepTheoDienTichGiam();
                    System.out.println("Da sap xep theo dien tich!");
                    ds.xuatDanhSach();
                    break;

                case 7:
                    ds.sapXepTheoSoBongDen();
                    System.out.println("Da sap xep theo so bong den!");
                    ds.xuatDanhSach();
                    break;

                case 8:
                    capNhatSoMayTinh();
                    break;

                case 9:
                    xoaPhong();
                    break;

                case 10:
                    System.out.println(
                            "Tong so phong hoc: "
                            + ds.tinhTongSoPhong()
                    );
                    break;

                case 11:
                    ds.xuatPhongMayCo60May();
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);
    }

    public static void main(String[] args) {
        menu();
        sc.close();
    }
}
