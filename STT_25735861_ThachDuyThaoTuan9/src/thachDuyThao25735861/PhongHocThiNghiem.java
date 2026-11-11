
package thachDuyThao25735861;

public class PhongHocThiNghiem extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;

    public PhongHocThiNghiem(String maPhong, String dayNha,
                             float dienTich, int soBongDen,
                             String chuyenNganh, int sucChua,
                             boolean coBonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.coBonRua = coBonRua;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public boolean isCoBonRua() {
        return coBonRua;
    }

    public void setCoBonRua(boolean coBonRua) {
        this.coBonRua = coBonRua;
    }

    @Override
    public boolean datChuan() {
        return duAnhSang() && coBonRua;
    }

    @Override
    public String toString() {
        return String.format(
            "Phòng thí nghiệm | Mã: %s | Dãy: %s"
            + " | Diện tích: %.2f m2 | Bóng đèn: %d"
            + " | Chuyên ngành: %s | Sức chứa: %d"
            + " | Bồn rửa: %s | Đạt chuẩn: %s",
            maPhong, dayNha, dienTich, soBongDen,
            chuyenNganh, sucChua,
            coBonRua ? "Có" : "Không",
            datChuan() ? "Có" : "Không"
        );
    }
}
