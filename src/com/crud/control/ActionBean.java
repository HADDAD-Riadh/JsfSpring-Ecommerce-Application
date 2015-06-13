	package com.crud.control;
	
	import java.io.Serializable;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
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
	import com.NetTrading.server.ibatis.dao.OrdreDAO;
	import com.NetTrading.server.ibatis.daoImpl.ActionDAOImpl;
	import com.NetTrading.server.ibatis.model.Action;
	import com.NetTrading.server.ibatis.model.Client;
	import com.NetTrading.server.ibatis.model.Ordre;
	
	@ManagedBean
	@SessionScoped
	public class ActionBean implements Serializable {
	
		private static final long serialVersionUID = 1L;
		private Client client = new Client();
		String dateString = "0000/00/00";
		private Action selectedUser;
		
	
		private Ordre ordre = new Ordre();
	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
	
		public Ordre getOrdre() throws ParseException {
	
			ordre.setEtat("A envoyé");
			ordre.setIdClient(StaticData.idclient);
			ordre.setIdAction(selectedUser.getNumAction());
			ordre.setDateExec(formatter.parse(dateString));
			//ordre.setNumOrdre(5);
	
			return ordre;
		}
	
		public void setOrdre(Ordre ordre) {
			this.ordre = ordre;
		}
	
		public Action getselectedUser() {
	
			if (selectedUser == null) {
	
				selectedUser = new Action();
	
			}
	
			return selectedUser;
		}
	
		public void setselectedUser(Action selectedUser) {
			this.selectedUser = selectedUser;
		}
	
		ActionDAOImpl ada = (ActionDAOImpl) MyContext.con.getBean("ActionDAOImpl");
		private List<Action> actions;
	
		public ActionBean() {
			actions = ada.getAll();
		}
	
		public List<Action> getActions() {
			return actions;
		}
	
		public void setActions(List<Action> actions) {
			this.actions = actions;
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
			dao.insert(client);
			showMessage("Utilisateur " + client.getNom()
					+ " est ajouté Avec Succes!");
	
		}
	
		public void ajouterOrdre(ActionEvent evt) {
			
			ApplicationContext context = MyContext.con;
			OrdreDAO dao = (OrdreDAO) context.getBean("OrdreDAOImpl");
			formatter.format(ordre.getDateExec());
			formatter.format(ordre.getDateOrdre());
			
			dao.insert(ordre);
			showMessage("" + ordre.getTypeOrdre()
					+ " est envoyé Avec Succes!");
			System.out.println("Ordre envoyé");
	
		}
	
		private void showMessage(String summary) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(summary));
		}
	
		public void limpar() {
			client = new Client();
		}
	
		public void rowSelect(SelectEvent event) {
			selectedUser = (Action) event.getObject();
	
		}
	
		public void onActionSelect(SelectEvent event) {
			this.selectedUser = (Action) event.getObject();
	
		}
	
		public void onActionUnselect(UnselectEvent event) {
			selectedUser = null;
		}
	
	}
