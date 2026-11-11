package tuan5;

import java.util.Scanner;

public class DanhSachCongNhan {

    private CongNhan[] cnr;
    private int count;

    public DanhSachCongNhan(int n) {
        cnr = new CongNhan[n];
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void TangSLCN() {
        if (count == cnr.length) {
            int newLength;

            if (cnr.length == 0) {
                newLength = 1;
            } else {
                newLength = cnr.length * 2;
            }

            CongNhan[] tam = new CongNhan[newLength];

            System.arraycopy(cnr, 0, tam, 0, count);

            cnr = tam;
        }
    }

    public boolean ThemCongNhan(CongNhan crom) {
        for (int i = 0; i < count; i++) {
            if (cnr[i].getMaCN().equalsIgnoreCase(crom.getMaCN())) {
                return false;
            }
        }

        TangSLCN();

        cnr[count] = crom;
        count++;

        return true;
    }

    public void inCN() {
        if (count == 0) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(cnr[i]);
        }
    }

    public int TinhSoCN() {
        return count;
    }

    public void CongNhanTren200SP() {
        boolean coCN = false;

        for (int i = 0; i < count; i++) {
            if (cnr[i].getmSoSP() > 200) {
                System.out.println(cnr[i]);
                coCN = true;
            }
        }

        if (!coCN) {
            System.out.println("Khong co cong nhan nao co tren 200 san pham.");
        }
    }

    public void SapXepCongNhanGiamDanTheoSoSP() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (cnr[i].getmSoSP() < cnr[j].getmSoSP()) {
                    CongNhan temp = cnr[i];
                    cnr[i] = cnr[j];
                    cnr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        while (true) {
            try {
                System.out.print("Nhap so luong cong nhan: ");
                n = sc.nextInt();
                sc.nextLine();

                if (n > 0) {
                    break;
                }

                System.out.println("So luong cong nhan phai lon hon 0!");

            } catch (Exception e) {
                System.out.println("Vui long nhap so nguyen!");
                sc.nextLine();
            }
        }

        DanhSachCongNhan ds = new DanhSachCongNhan(n);

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Cong nhan thu " + (i + 1) + " ---");

            System.out.print("Nhap ma cong nhan: ");
            String maCN = sc.nextLine();

            System.out.print("Nhap ho: ");
            String ho = sc.nextLine();

            System.out.print("Nhap ten: ");
            String ten = sc.nextLine();

            int soSP;

            while (true) {
                try {
                    System.out.print("Nhap so san pham: ");
                    soSP = sc.nextInt();
                    sc.nextLine();

                    if (soSP > 0) {
                        break;
                    }

                    System.out.println("So san pham phai lon hon 0!");

                } catch (Exception e) {
                    System.out.println("Vui long nhap so nguyen!");
                    sc.nextLine();
                }
            }

            try {
                CongNhan cn = new CongNhan(maCN, ho, ten, soSP);

                if (ds.ThemCongNhan(cn)) {
                    System.out.println("Them cong nhan thanh cong!");
                } else {
                    System.out.println("Ma cong nhan bi trung!");
                    System.out.println("Vui long nhap lai cong nhan nay.");
                    i--;
                }

            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
                i--;
            }
        }

        System.out.println("\n       DANH SACH CONG NHAN");
        ds.inCN();

        System.out.println("\nSo luong cong nhan: " + ds.TinhSoCN());

        System.out.println("\n CONG NHAN CO TREN 200 SAN PHAM");
        ds.CongNhanTren200SP();

        ds.SapXepCongNhanGiamDanTheoSoSP();

        System.out.println("\n DANH SACH GIAM DAN THEO SO SAN PHAM");
        ds.inCN();

        sc.close();
    }

}