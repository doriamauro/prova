package bean;

public class DatiRate {

	
	private double tan;
	private double maxTaeg;
	private int nRate;

	
	public DatiRate() {
		
	}
	
	public DatiRate(double tan, double maxTaeg, int nRate) {
		this.tan= tan;
		this.maxTaeg= maxTaeg;
		this.nRate= nRate;
	}



	public double getTan() {
		return tan;
	}

	public void setTan(double tan) {
		this.tan = tan;
	}

	public double getMaxTaeg() {
		return maxTaeg;
	}

	public void setMaxTaeg(double maxTaeg) {
		this.maxTaeg = maxTaeg;
	}

	public int getnRate() {
		return nRate;
	}

	public void setnRate(int nRate) {
		this.nRate = nRate;
	}
	
	
}
