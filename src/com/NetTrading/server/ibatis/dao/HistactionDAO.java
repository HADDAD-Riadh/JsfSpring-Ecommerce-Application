package com.NetTrading.server.ibatis.dao;

import com.NetTrading.server.ibatis.model.Histaction;

public interface HistactionDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table histaction
	 * @ibatorgenerated  Mon Jan 14 17:44:12 CET 2013
	 */
	int deleteByPrimaryKey(Integer idHistact);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table histaction
	 * @ibatorgenerated  Mon Jan 14 17:44:12 CET 2013
	 */
	void insert(Histaction record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table histaction
	 * @ibatorgenerated  Mon Jan 14 17:44:12 CET 2013
	 */
	void insertSelective(Histaction record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table histaction
	 * @ibatorgenerated  Mon Jan 14 17:44:12 CET 2013
	 */
	Histaction selectByPrimaryKey(Integer idHistact);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table histaction
	 * @ibatorgenerated  Mon Jan 14 17:44:12 CET 2013
	 */
	int updateByPrimaryKeySelective(Histaction record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table histaction
	 * @ibatorgenerated  Mon Jan 14 17:44:12 CET 2013
	 */
	int updateByPrimaryKey(Histaction record);
}