package com.NetTrading.server.ibatis.model;

import java.util.Date;

public class Portefeuille {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column portefeuille.numPf
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	private Integer numPf;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column portefeuille.idClient
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	private Integer idClient;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column portefeuille.numPf
	 * @return  the value of portefeuille.numPf
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	public Integer getNumPf() {
		return numPf;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column portefeuille.numPf
	 * @param numPf  the value for portefeuille.numPf
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	public void setNumPf(Integer numPf) {
		this.numPf = numPf;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column portefeuille.idClient
	 * @return  the value of portefeuille.idClient
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	public Integer getIdClient() {
		return idClient;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column portefeuille.idClient
	 * @param idClient  the value for portefeuille.idClient
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
}