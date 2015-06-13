package com.webservice;


import javax.jws.WebMethod;
import javax.jws.WebService;


import org.springframework.context.ApplicationContext;

import com.NetTrading.config.MyContext;

import com.NetTrading.server.ibatis.daoImpl.AdministrateurDAOImpl;
import com.NetTrading.server.ibatis.daoImpl.ClientDAOImpl;
import com.NetTrading.server.ibatis.daoImpl.TraderDAOImpl;
import com.NetTrading.server.ibatis.model.Administrateur;
import com.NetTrading.server.ibatis.model.Client;
import com.NetTrading.server.ibatis.model.Trader;

@WebService
public class AdminTrader {

	@WebMethod
	public String login(String login, String password) {

		Administrateur admin = new Administrateur();
		ApplicationContext contexte = MyContext.con;
		AdministrateurDAOImpl admindao = (AdministrateurDAOImpl) contexte
				.getBean("AdministrateurDAOImpl");
		Trader trader = new Trader();
		ApplicationContext context = MyContext.con;
		TraderDAOImpl traderdao = (TraderDAOImpl) context
				.getBean("TraderDAOImpl");

		if ((admindao.isExist(admin.getLogin(), admin.getPassword())) != null) {
			return "administrateur";
		} else if ((traderdao.isExist(trader.getLogin(), trader.getPassword())) != null) {
			return "tradder";
		} else {
			return "erreur";
		}

	}

	@WebMethod
	public String affectTraderClien(String matricule, int idClient) {
		ApplicationContext contexte = MyContext.con;
		ClientDAOImpl dao = (ClientDAOImpl) contexte.getBean("ClientDAOImpl");
		Client c = new Client();

		try {
			c = dao.selectByPrimaryKey(idClient);// choisir le client qui n'a
													// pas encors un trader
			c.setMatricule(matricule);// on va lui associer un matricule trader
			dao.updateByPrimaryKey(c);// mise a jour de matricule client cad
										// doit avoir un trader
			return "succes";
		} catch (Exception e) {
			return "erreur";
		}

	}
	@WebMethod
	public String affectGradeTrader(String matricule, String grade) {
		ApplicationContext contexte = MyContext.con;
		TraderDAOImpl dao = (TraderDAOImpl) contexte.getBean("TraderDAOImpl");
		Trader t= new Trader();

		try {
			t = dao.selectByPrimaryKey(matricule);// choisir trader
			t.setEtat(grade);// associer grade au trader
			dao.updateByPrimaryKey(t);// mise a jour de l'etat trader cad
										// doit avoir un etat
			return "succes";
		} catch (Exception e) {
			return "erreur";
		}

	}
	
	
	
	@WebMethod
	public String SupprssionClient(int idClient) {
		ApplicationContext contexte = MyContext.con;
		ClientDAOImpl dao = (ClientDAOImpl) contexte.getBean("ClientDAOImpl");
		

		try {
			dao.deleteByPrimaryKey(idClient);
			return "supprime";
		} catch (Exception e) {
			return "erreur";
		}

	}

	
	@WebMethod
	public String SupprssionTrader(String matricule ) {
		ApplicationContext contexte = MyContext.con;
		TraderDAOImpl dao = (TraderDAOImpl) contexte.getBean("TraderDAOImpl");
		

		try {
		
			dao.deleteByPrimaryKey(matricule);
			return "supprime";
		} catch (Exception e) {
			return "erreur";
		}

	}

}
