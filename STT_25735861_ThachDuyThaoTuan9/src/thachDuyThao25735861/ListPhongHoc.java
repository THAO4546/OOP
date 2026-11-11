package thachDuyThao25735861;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListPhongHoc {
    private ArrayList<PhongHoc> ds;

    public ListPhongHoc() {
        ds = new ArrayList<PhongHoc>();
    }

    public boolean themPhong(PhongHoc p) {
        if (p == null || p.getMaPhong() == null
                || p.getMaPhong().trim().isEmpty()) {
            return false;
        }

        if (timPhong(p.getMaPhong()) != null) {
            return false;
        }

        ds.add(p);
        return true;
    }

    public PhongHoc timPhong(String maPhong) {
        if (maPhong == null || maPhong.trim().isEmpty()) {
            return null;
        }

        for (PhongHoc p : ds) {
            if (p.getMaPhong() != null
                    && p.getMaPhong().equalsIgnoreCase(maPhong.trim())) {
                return p;
            }
        }

        return null;
    }

    public ArrayList<PhongHoc> getDanhSach() {
        return new ArrayList<PhongHoc>(ds);
    }

    public void xuatDanhSach() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach phong hoc rong!");
            return;
        }

        for (PhongHoc p : ds) {
            System.out.println(p);
        }
    }

    public ArrayList<PhongHoc> getPhongDatChuan() {
        ArrayList<PhongHoc> ketQua = new ArrayList<PhongHoc>();

        for (PhongHoc p : ds) {
            if (p.datChuan()) {
                ketQua.add(p);
            }
        }

        return ketQua;
    }

    public void xuatPhongDatChuan() {
        ArrayList<PhongHoc> ketQua = getPhongDatChuan();

        if (ketQua.isEmpty()) {
            System.out.println("Khong co phong dat chuan!");
            return;
        }

        for (PhongHoc p : ketQua) {
            System.out.println(p);
        }
    }

    public void sapXepTheoDayNha() {
        Collections.sort(ds, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                String d1 = p1.getDayNha() == null
                        ? "" : p1.getDayNha();
                String d2 = p2.getDayNha() == null
                        ? "" : p2.getDayNha();

                return d1.compareToIgnoreCase(d2);
            }
        });
    }

    public void sapXepTheoDienTichGiam() {
        Collections.sort(ds, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return Float.compare(
                        p2.getDienTich(),
                        p1.getDienTich()
                );
            }
        });
    }

    public void sapXepTheoSoBongDen() {
        Collections.sort(ds, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return Integer.compare(
                        p1.getSoBongDen(),
                        p2.getSoBongDen()
                );
            }
        });
    }

    public boolean capNhatSoMayTinh(String maPhong, int soMayMoi) {
        if (soMayMoi < 0) {
            return false;
        }

        PhongHoc p = timPhong(maPhong);

        if (p instanceof PhongHocMayTinh) {
            ((PhongHocMayTinh) p).setSoMayTinh(soMayMoi);
            return true;
        }

        return false;
    }

    public boolean xoaPhong(String maPhong) {
        PhongHoc p = timPhong(maPhong);

        if (p == null) {
            return false;
        }

        return ds.remove(p);
    }

    public int tinhTongSoPhong() {
        return ds.size();
    }

    public ArrayList<PhongHocMayTinh> getPhongMayCo60May() {
        ArrayList<PhongHocMayTinh> ketQua =
                new ArrayList<PhongHocMayTinh>();

        for (PhongHoc p : ds) {
            if (p instanceof PhongHocMayTinh) {
                PhongHocMayTinh pm = (PhongHocMayTinh) p;

                if (pm.getSoMayTinh() == 60) {
                    ketQua.add(pm);
                }
            }
        }

        return ketQua;
    }

    public void xuatPhongMayCo60May() {
        ArrayList<PhongHocMayTinh> ketQua = getPhongMayCo60May();

        if (ketQua.isEmpty()) {
            System.out.println(
                    "Khong co phong may nao co 60 may!"
            );
            return;
        }

        for (PhongHocMayTinh p : ketQua) {
            System.out.println(p);
        }
    }
}
