package com.NetTrading.server.ibatis.daoImpl;

import java.util.List;

import com.NetTrading.server.ibatis.dao.OrdreDAO;
import com.NetTrading.server.ibatis.model.Ordre;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class OrdreDAOImpl extends SqlMapClientDaoSupport implements OrdreDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ordre
	 * @ibatorgenerated  Wed Jan 23 17:31:43 CET 2013
	 */
	public OrdreDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ordre
	 * @ibatorgenerated  Wed Jan 23 17:31:43 CET 2013
	 */
	public int deleteByPrimaryKey(Integer numOrdre) {
		Ordre key = new Ordre();
		key.setNumOrdre(numOrdre);
		int rows = getSqlMapClientTemplate().delete(
				"ordre.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ordre
	 * @ibatorgenerated  Wed Jan 23 17:31:43 CET 2013
	 */
	public void insert(Ordre record) {
		getSqlMapClientTemplate()
				.insert("ordre.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ordre
	 * @ibatorgenerated  Wed Jan 23 17:31:43 CET 2013
	 */
	public void insertSelective(Ordre record) {
		getSqlMapClientTemplate().insert(
				"ordre.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ordre
	 * @ibatorgenerated  Wed Jan 23 17:31:43 CET 2013
	 */
	public Ordre selectByPrimaryKey(Integer numOrdre) {
		Ordre key = new Ordre();
		key.setNumOrdre(numOrdre);
		Ordre record = (Ordre) getSqlMapClientTemplate().queryForObject(
				"ordre.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ordre
	 * @ibatorgenerated  Wed Jan 23 17:31:43 CET 2013
	 */
	public int updateByPrimaryKeySelective(Ordre record) {
		int rows = getSqlMapClientTemplate().update(
				"ordre.ibatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table ordre
	 * @ibatorgenerated  Wed Jan 23 17:31:43 CET 2013
	 */
	public int updateByPrimaryKey(Ordre record) {
		int rows = getSqlMapClientTemplate().update(
				"ordre.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
public List<Ordre>getAll(){
    	
    	return (List<Ordre>)getSqlMapClientTemplate().queryForList("ordre.getAll");
    }
}