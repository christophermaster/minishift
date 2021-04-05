package com.safre.coppel.mss_afiglobal.models.entity;

/**
 * @author christopher J. Siverio 11/12/2020 Afore Coppel
 */

public class MssAfilGlobalEntity {

	private Integer idServicio;
	private String clv;
	private String descripcion;
	private String ip;
	private String puerto;
	private String url;
	private Integer estadoServicio;

	public MssAfilGlobalEntity() {
	}

	/**
	 * @param id
	 * @param idServicio
	 * @param clv
	 * @param descripcion
	 * @param ip
	 * @param puerto
	 * @param url
	 * @param estadoServicio
	 * @param fechaCreacion
	 */
	public MssAfilGlobalEntity(Integer idServicio, String clv, String descripcion, String ip, String puerto, String url,
			Integer estadoServicio) {
		super();
		this.idServicio = idServicio;
		this.clv = clv;
		this.descripcion = descripcion;
		this.ip = ip;
		this.puerto = puerto;
		this.url = url;
		this.estadoServicio = estadoServicio;
	}

	/**
	 * @return the idServicio
	 */
	public Integer getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio the idServicio to set
	 */
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
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

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the puerto
	 */
	public String getPuerto() {
		return puerto;
	}

	/**
	 * @param puerto the puerto to set
	 */
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the estadoServicio
	 */
	public Integer getEstadoServicio() {
		return estadoServicio;
	}

	/**
	 * @param estadoServicio the estadoServicio to set
	 */
	public void setEstadoServicio(Integer estadoServicio) {
		this.estadoServicio = estadoServicio;
	}

}
