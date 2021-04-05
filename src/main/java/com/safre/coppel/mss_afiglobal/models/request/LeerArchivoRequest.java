package com.safre.coppel.mss_afiglobal.models.request;

public class LeerArchivoRequest {

	private String servidor;
	private String puerto;
	private String uFtp;
	private String pFtp;
	private String localPath;
	private String filename;

	public LeerArchivoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeerArchivoRequest(String servidor, String puerto, String uFtp, String pFtp, String localPath,
			String filename) {
		super();
		this.servidor = servidor;
		this.puerto = puerto;
		this.uFtp = uFtp;
		this.pFtp = pFtp;
		this.localPath = localPath;
		this.filename = filename;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getuFtp() {
		return uFtp;
	}

	public void setuFtp(String uFtp) {
		this.uFtp = uFtp;
	}

	public String getpFtp() {
		return pFtp;
	}

	public void setpFtp(String pFtp) {
		this.pFtp = pFtp;
	}

	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "LeerArchivoRequest [servidor=" + servidor + ", puerto=" + puerto + ", uFtp=" + uFtp + ", pFtp=" + pFtp
				+ ", localPath=" + localPath + ", filename=" + filename + "]";
	}

}
