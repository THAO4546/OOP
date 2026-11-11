package tuan1.HinhTron;

public class HinhTron {
	private Toado tam;
	private double banKinh;
	
	
	public Toado getTam() {
		return tam;
	}


	public void setTam(Toado tam) {
		this.tam = tam;
	}


	public double getBanKinh() {
		return banKinh;
	}


	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}


	public HinhTron(Toado tam, double banKinh) {
		this.tam = tam;
		this.banKinh = banKinh;
	}
	public double getDT() {
		return banKinh*banKinh*3.14;
	}
	public double getCv() {
		return 2*banKinh*3.14;
	}


	public static void main(String[] args) {
		HinhTron t1 = new HinhTron(new Toado("O",3,2),5);
		System.out.println("thong tin hinh tron: ");
		System.out.println("Hinh Tron "+t1.getTam().getTen());
		System.out.println("Hinh tron co ban kinh: "+t1.getBanKinh());
		System.out.println("Dien Tich hinh tron: "+t1.getDT());
		System.out.println("Chu Vi Hinh tron: "+t1.getCv());
	}

}
