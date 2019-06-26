package bean;

public class DatiRateOrdine {
	//
	private int idOrd;
	private double tan;
	private double maxTaeg;
	private int nRate;
	
	public DatiRateOrdine() {}

	public DatiRateOrdine(int idOrd, double tan, double maxTaeg, int nRate) {
		this.idOrd = idOrd;
		this.tan = tan;
		this.maxTaeg = maxTaeg;
		this.nRate = nRate;
	}

	public int getIdOrd() {
		return idOrd;
	}

	public void setIdOrd(int idOrd) {
		this.idOrd = idOrd;
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

	@Override
	public String toString() {
		return "DatiRateOrdine [idOrd=" + idOrd + ", tan=" + tan + ", maxTaeg=" + maxTaeg + ", nRate=" + nRate + "]";
	}
	
	
}
