package tuan4;

public class CD {
	private String MaCD;
	private String TuaCD;
	private String caSy;
	private int soBaiHat;
	private float gia;
	
	
	
	public String getMaCD() {
		return MaCD;
	}



	public void setMaCD(String maCD) {
		this.MaCD = maCD;
	}



	public String getTuaCD() {
		return TuaCD;
	}



	public void setTuaCD(String tuaCD) {
		this.TuaCD = tuaCD;
	}



	public String getCaSy() {
		return caSy;
	}



	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}



	public int getSoBaiHat() {
		return soBaiHat;
	}



	public void setSoBaiHat(int soBai) throws Exception {
		if(soBai>0) {
			this.soBaiHat = soBai;
		} else {
			throw new Exception("So bai hat phai lon hon 0");
		}
	}



	public float getGia() {
		return gia;
	}



	public void setGia(float gia) {
		this.gia = gia;
	}
	
	

	public CD(String maCD, String tuaCD, String caSy, int soBaiHat, float gia) {
		super();
		MaCD = maCD;
		TuaCD = tuaCD;
		this.caSy = caSy;
		this.soBaiHat = soBaiHat;
		this.gia = gia;
	}

	public static void tieude() {
	    System.out.println("In Danh Sach CD");

	    for (int i = 0; i < 70; i++) {
	        System.out.print("-");
	    }
	    System.out.println();

	    String s = String.format(
	        "|%10s|%15s|%15s|%12s|%10s|%12s|",
	        "Ma CD",
	        "Tua CD",
	        "Ca Sy",
	        "So Bai Hat",
	        "Don Gia",
	        "Thanh Tien"
	    );

	    System.out.println(s);

	    for (int i = 0; i < 70; i++) {
	        System.out.print("-");
	    }
	    System.out.println();
	}

	@Override
	public String toString() {
		return String.format("|%10s|%10s|%10s|%10s|%10s|%10s",
			MaCD,TuaCD,caSy,soBaiHat,gia,gia * soBaiHat);
	}
}