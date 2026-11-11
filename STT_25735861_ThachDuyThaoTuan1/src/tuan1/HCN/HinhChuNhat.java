package tuan1.HCN;

public class HinhChuNhat {
	
	private double chieudai;
	private double chieurong;
	
	public double getChieudai() {
		return chieudai;
	}


	public void setChieudai(double cd) throws Exception {
		if (cd>0) {
			this.chieudai = cd;
		}else {
			throw new Exception("cd>0");
		}
		
	}


	public double getChieurong() {
		return chieurong;
	}


	public void setChieurong(double cr) throws Exception {
		if (cr>0) {
			this.chieurong = cr;
		}else {
			throw new Exception("cr>0");
		}
	}
	

	public HinhChuNhat(double cd, double chieurong) throws Exception {
		if (cd>0) {
			this.chieudai = cd;
		}else {
			throw new Exception("cd>0");
		}
		this.chieurong = chieurong;
	}
	public HinhChuNhat() {
		
	}
	public double getDt() {
		return this.chieudai*this.getChieurong();
	}
	public double getCV() {
		return (this.chieudai+this.getChieurong())*2;
	}


	public static void main(String[] args) throws Exception {
		HinhChuNhat h1 = new HinhChuNhat(10,5);
		
		System.out.println("Chieu Dai hinh Chu Nhat:"+h1.getChieudai());
		System.out.println("Chieu rong hinh Chu Nhat:"+h1.getChieurong());
		System.out.println("Dien Tich Hinh Chu Nhat:"+h1.getDt());
		System.out.println("Chu Vi hinh Chu Nhat:"+h1.getCV());
	}

}
