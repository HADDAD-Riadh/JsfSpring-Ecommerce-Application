package com.NetTrading.server.ibatis.dao;

import com.NetTrading.server.ibatis.model.Action;

public interface ActionDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table action
	 * @ibatorgenerated  Thu Jan 17 14:20:22 CET 2013
	 */
	int deleteByPrimaryKey(Integer numAction);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table action
	 * @ibatorgenerated  Thu Jan 17 14:20:22 CET 2013
	 */
	void insert(Action record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table action
	 * @ibatorgenerated  Thu Jan 17 14:20:22 CET 2013
	 */
	void insertSelective(Action record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table action
	 * @ibatorgenerated  Thu Jan 17 14:20:22 CET 2013
	 */
	Action selectByPrimaryKey(Integer numAction);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table action
	 * @ibatorgenerated  Thu Jan 17 14:20:22 CET 2013
	 */
	int updateByPrimaryKeySelective(Action record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table action
	 * @ibatorgenerated  Thu Jan 17 14:20:22 CET 2013
	 */
	int updateByPrimaryKey(Action record);
}