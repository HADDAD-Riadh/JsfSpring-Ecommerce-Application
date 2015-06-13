package com.crud.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.context.ApplicationContext;
import com.NetTrading.config.MyContext;
import com.NetTrading.config.StaticData;
import com.NetTrading.server.ibatis.dao.ClientDAO;
import com.NetTrading.server.ibatis.dao.PortefeuilleDAO;
import com.NetTrading.server.ibatis.daoImpl.HistoriquepfDAOImpl;
import com.NetTrading.server.ibatis.daoImpl.PortefeuilleDAOImpl;
import com.NetTrading.server.ibatis.model.Client;
import com.NetTrading.server.ibatis.model.HistPorTwo;
import com.NetTrading.server.ibatis.model.Historiquepf;
import com.NetTrading.server.ibatis.model.Portefeuille;

@ManagedBean
@SessionScoped
public class ClientBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Client client = new Client();
	private Portefeuille portefeuille = new Portefeuille();
	private Portefeuille selectedPortefeuille;
	private Portefeuille pf;

	public Portefeuille getPf() {
		return pf;
	}

	public void setPf(Portefeuille pf) {
		this.pf = pf;
	}

	public Portefeuille getSelectedPortefeuille() {
		return selectedPortefeuille;
	}

	public void setSelectedPortefeuille(Portefeuille selectedPortefeuille) {
		this.selectedPortefeuille = selectedPortefeuille;
	}

	public Portefeuille getPortefeuille() {
		return portefeuille;
	}

	public void setPortefeuille(Portefeuille portefeuille) {
		this.portefeuille = portefeuille;
	}

	public List<Portefeuille> getPortefeuilles() {
		return portefeuilles;
	}

	public void setPortefeuilles(List<Portefeuille> portefeuilles) {
		this.portefeuilles = portefeuilles;
	}

	private Portefeuille selectedUser;

	public Portefeuille getselectedUser() {

		if (selectedUser == null) {

			selectedUser = new Portefeuille();

		}

		return selectedUser;
	}

	public void setselectedUser(Portefeuille selectedUser) {
		this.selectedUser = selectedUser;
	}

	PortefeuilleDAOImpl ada = (PortefeuilleDAOImpl) MyContext.con
			.getBean("PortefeuilleDAOImpl");

	private List<Portefeuille> portefeuilles;
	Historiquepf hp = new Historiquepf();
	public ClientBean() {
		// portefeuille = ada.getByNumPf(StaticData.numPfClient);
		portefeuille = ada.getByNumClient(StaticData.idclient);

		
		hp.setNumPf(portefeuille.getNumPf());
		HistoriquepfDAOImpl ada = (HistoriquepfDAOImpl) MyContext.con
				.getBean("HistoriquepfDAOImpl");
		List<HistPorTwo> listport = ada.getPortfeuilleActions(hp);
		//System.out.println("historique " + listport.size());

		portefeuilles = new ArrayList<Portefeuille>();
		portefeuilles.add(portefeuille);

	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void ajouter(ActionEvent evt) {
		ApplicationContext context = MyContext.con;
		ClientDAO dao = (ClientDAO) context.getBean("ClientDAOImpl");
		System.out.println(client.getEmail());
		dao.insert(client);
		// PortefeuilleDAO por = (PortefeuilleDAO)
		// context.getBean("PortefeuilleDAOImpl");
		// pf.setIdClient(client.getIdClient());
		// por.insert(pf);

		showMessage("Bienvenu " + client.getNom() + " vous etes bien inscrit !");

	}

	private void showMessage(String summary) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(summary));
	}

	public void limpar() {
		client = new Client();
	}

	public void rowSelect(SelectEvent event) {
		selectedUser = (Portefeuille) event.getObject();
		System.out.println("selectedUser = " + selectedUser.getNumPf());
	}

	public void onEntrepriseSelect(SelectEvent event) {
		this.selectedUser = (Portefeuille) event.getObject();
		System.out.println("selectedUser = " + selectedUser.getNumPf());
	}

	public void onUserUnselect(UnselectEvent event) {
		selectedUser = null;
	}

	public void atualizar() {
		ApplicationContext context = MyContext.con;
		PortefeuilleDAO dao = (PortefeuilleDAO) context
				.getBean("PortefeuilleDAOImpl");
		dao.updateByPrimaryKey(portefeuille);

		showMessage("Utilisateur " + portefeuille.getNumPf()
				+ " est modifié effectués!");
	}

	// public void remover() {
	// ApplicationContext context = MyContext.con;
	// PortefeuilleDAO dao = (PortefeuilleDAO) context
	// .getBean("PortefeuilleDAOImpl");
	// dao.deleteByPrimaryKey(portefeuille.getNumAction(),
	// portefeuille.getNumPf());
	//
	// showMessage("Utilisateur" + portefeuille.getNumPf() + "est Supprimé!");
	// }

	public void limpar2() {
		portefeuille = new Portefeuille();
	}

}
