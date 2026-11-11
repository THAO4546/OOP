package tuan5;

public class CongNhan {

    private String maCN;
    private String mHo;
    private String mTen;
    private int mSoSP;

    public CongNhan(String maCN, String mHo, String mTen, int mSoSP) throws Exception {
        this.maCN = maCN;
        this.mHo = mHo;
        this.mTen = mTen;
        setmSoSP(mSoSP);
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getmHo() {
        return mHo;
    }

    public void setmHo(String mHo) {
        this.mHo = mHo;
    }

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }

    public int getmSoSP() {
        return mSoSP;
    }

    public void setmSoSP(int mSoSP) throws Exception {
        if (mSoSP > 0) {
            this.mSoSP = mSoSP;
        } else {
            throw new Exception("So san pham phai lon hon 0!");
        }
    }

    public float tinhLuong() {
        if (mSoSP <= 199) {
            return mSoSP * 0.5f;
        } else if (mSoSP <= 399) {
            return mSoSP * 0.55f;
        } else if (mSoSP <= 599) {
            return mSoSP * 0.6f;
        } else {
            return mSoSP * 0.65f;
        }
    }

    @Override
    public String toString() {
        return "MaCN: " + maCN
                + ", Ho: " + mHo
                + ", Ten: " + mTen
                + ", SoSP: " + mSoSP
                + ", Luong: " + tinhLuong();
    }
}