package com.NetTrading.server.ibatis.dao;

import com.NetTrading.server.ibatis.model.Trader;

public interface TraderDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table trader
	 * @ibatorgenerated  Wed Jan 23 11:22:10 CET 2013
	 */
	int deleteByPrimaryKey(String matricule);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table trader
	 * @ibatorgenerated  Wed Jan 23 11:22:10 CET 2013
	 */
	void insert(Trader record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table trader
	 * @ibatorgenerated  Wed Jan 23 11:22:10 CET 2013
	 */
	void insertSelective(Trader record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table trader
	 * @ibatorgenerated  Wed Jan 23 11:22:10 CET 2013
	 */
	Trader selectByPrimaryKey(String matricule);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table trader
	 * @ibatorgenerated  Wed Jan 23 11:22:10 CET 2013
	 */
	int updateByPrimaryKeySelective(Trader record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table trader
	 * @ibatorgenerated  Wed Jan 23 11:22:10 CET 2013
	 */
	int updateByPrimaryKey(Trader record);
}