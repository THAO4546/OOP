
package thachDuyThao25735861;

public class PhongHocMayTinh extends PhongHoc {
    private int soMayTinh;

    // Constructor
    public PhongHocMayTinh(String maPhong, String dayNha,
                        float dienTich, int soBongDen,
                        int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

    // Kiểm tra phòng đạt chuẩn
    @Override
    public boolean datChuan() {
        return duAnhSang()
                && soMayTinh > 0
                && dienTich / soMayTinh >= 1.5;
    }

    @Override
    public String toString() {
        return String.format(
            "Phòng máy tính | Mã: %s | Dãy: %s"
            + " | Diện tích: %.2f m2 | Bóng đèn: %d"
            + " | Số máy tính: %d | Đạt chuẩn: %s",
            maPhong, dayNha, dienTich, soBongDen,
            soMayTinh,
            datChuan() ? "Có" : "Không"
        );
    }
}
