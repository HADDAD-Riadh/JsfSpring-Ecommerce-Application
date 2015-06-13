package com.crud.control;

import java.io.IOException;
import java.io.Serializable;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.context.ApplicationContext;

import com.NetTrading.config.MyContext;
import com.NetTrading.config.StaticData;

import com.NetTrading.server.ibatis.daoImpl.ClientDAOImpl;

import com.NetTrading.server.ibatis.model.Client;


public class LoginBean implements Serializable {

	/**
 * 
 */
	private static final long serialVersionUID = 1L;

	Client client = new Client();
	private int idclient;
	private int numPfClient;

	public int getNumPfClient() {
		return numPfClient;
	}

	public void setNumPfClient(int numPfClient) {
		this.numPfClient = numPfClient;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public Client getClient() {

		return client;
	}

	public LoginBean() {

	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void login(ActionEvent actionEvent) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		boolean loggedIn = false;
		String welcome = "http://localhost:8081/NetTradingPfsProject/faces/Act.xhtml";
		ApplicationContext contexte = MyContext.con;
		ClientDAOImpl dao = (ClientDAOImpl) contexte.getBean("ClientDAOImpl");

		if ((dao.isExist(client.getLogin(), client.getPassword())) != null) {
		
System.out.println((dao.isExist(client.getLogin(),
					client.getPassword()).getIdClient()));
			this.idclient = (dao.isExist(client.getLogin(),
					client.getPassword()).getIdClient());
			this.numPfClient = (dao.isExist(client.getLogin(),
					client.getPassword()).getNumPf());
			System.out.println((dao.isExist(client.getLogin(),
					client.getPassword()).getNumPf()));
			StaticData.idclient = this.idclient;
			StaticData.numPfClient = this.numPfClient;
			
			loggedIn = true;
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome",
					client.getLogin());
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect(welcome);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erreur de login", "login ou mot de passe incorrect");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		context.addCallbackParam("loggedIn", loggedIn);
	}

	public void Sinscrire(ActionEvent actionEvent) {

		@SuppressWarnings("unused")
		FacesMessage msg = null;

		ApplicationContext contexte = MyContext.con;
		ClientDAOImpl dao = (ClientDAOImpl) contexte.getBean("ClientDAOImpl");

		dao.insert(client);
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Inscription reussie", "Nous vous souheite le bienvenu");

	}
}
