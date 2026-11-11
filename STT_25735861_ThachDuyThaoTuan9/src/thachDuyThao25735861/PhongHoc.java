package thachDuyThao25735861;

import java.util.Objects;

public abstract class PhongHoc {
    protected String maPhong;
    protected String dayNha;
    protected float dienTich;
    protected int soBongDen;

    public PhongHoc() {
    }

    public PhongHoc(String maPhong, String dayNha,
                    float dienTich, int soBongDen) {
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        setDienTich(dienTich);
        setSoBongDen(soBongDen);
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public void setDayNha(String dayNha) {
        this.dayNha = dayNha;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        if (!Float.isFinite(dienTich) || dienTich <= 0) {
            throw new IllegalArgumentException(
                "Diện tích phải lớn hơn 0"
            );
        }
        this.dienTich = dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public void setSoBongDen(int soBongDen) {
        if (soBongDen < 0) {
            throw new IllegalArgumentException(
                "Số bóng đèn không được âm"
            );
        }
        this.soBongDen = soBongDen;
    }

    public boolean duAnhSang() {
        return dienTich > 0
            && soBongDen >= Math.ceil(dienTich / 10.0);
    }

    public abstract boolean datChuan();

    @Override
    public String toString() {
        return "PhongHoc [maPhong=" + maPhong
            + ", dayNha=" + dayNha
            + ", dienTich=" + dienTich
            + ", soBongDen=" + soBongDen + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhong);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof PhongHoc)) return false;

        PhongHoc other = (PhongHoc) obj;
        return Objects.equals(maPhong, other.maPhong);
    }
}