
package thachDuyThao25735861;

public class PhongHocLT extends PhongHoc {
    private boolean coMayChieu;

    public PhongHocLT(String maPhong, String dayNha,
                      float dienTich, int soBongDen,
                      boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }

    public boolean isCoMayChieu() {
        return coMayChieu;
    }

    public void setCoMayChieu(boolean coMayChieu) {
        this.coMayChieu = coMayChieu;
    }

    @Override
    public boolean datChuan() {
        return duAnhSang() && coMayChieu;
    }

    @Override
    public String toString() {
        return String.format(
            "Phòng lý thuyết | Mã: %s | Dãy: %s"
            + " | Diện tích: %.2f m2 | Bóng đèn: %d"
            + " | Máy chiếu: %s | Đạt chuẩn: %s",
            maPhong, dayNha, dienTich, soBongDen,
            coMayChieu ? "Có" : "Không",
            datChuan() ? "Có" : "Không"
        );
    }
}
