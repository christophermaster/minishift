package com.safre.coppel.mss_afiglobal.models.request;

/**
 * @author christopher J. Siverio 11/12/2020 Afore Coppel
 */
public class MssAfilGlobalRequest {

	// Nombre del MS a consultar
	private String clv;

	public MssAfilGlobalRequest() {
	}

	/**
	 * @param clv
	 */
	public MssAfilGlobalRequest(String clv) {
		super();
		this.clv = clv;
	}

	/**
	 * @return the clv
	 */
	public String getClv() {
		return clv;
	}

	/**
	 * @param clv the clv to set
	 */
	public void setClv(String clv) {
		this.clv = clv;
	}

	@Override
	public String toString() {
		return "MssAfilGlobalRequest [clv=" + clv + "]";
	}

}
