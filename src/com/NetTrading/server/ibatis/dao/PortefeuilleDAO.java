package com.NetTrading.server.ibatis.dao;

import com.NetTrading.server.ibatis.model.Portefeuille;

public interface PortefeuilleDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table portefeuille
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	int deleteByPrimaryKey(Integer numPf);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table portefeuille
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	void insert(Portefeuille record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table portefeuille
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	void insertSelective(Portefeuille record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table portefeuille
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	Portefeuille selectByPrimaryKey(Integer numPf);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table portefeuille
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	int updateByPrimaryKeySelective(Portefeuille record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table portefeuille
	 * @ibatorgenerated  Tue Jan 22 16:59:55 CET 2013
	 */
	int updateByPrimaryKey(Portefeuille record);
}