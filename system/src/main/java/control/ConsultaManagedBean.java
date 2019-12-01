package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

import model.Consulta;
import model.Paciente;

@ManagedBean(value = "consulta")
@RequestScoped
public class ConsultaManagedBean implements java.io.Serializable {
	private static Logger log = Logger.getLogger(ConsultaManagedBean.class);
	private static final long serialVersionUID = 1L;
	private Consulta consulta;
	private List<Consulta> consultas;
	private String dataConsulta;

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public List<Consulta> getConsultas() {
		findConsultas();
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public void initialize() {
		consulta = new Consulta();
		consulta.setPaciente(
				(Paciente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("paciente"));
		
	}

	public void limparPaciente() {

		log.info("Limpando dados Consulta");
		this.consulta.setData(null);
		this.consulta.setPaciente(null);
		this.consulta.setPesoAtual(null);
		this.consulta.setAlturaAtual(null);
		this.consulta.setPerimetroCefalico(null);
		this.consulta.setDiarreia(false);
		this.consulta.setPneumonia(false);
		this.consulta.setHospitalizacao(false);
		this.consulta.setIntroducaoAli(false);
		this.consulta.setOutros("");

	}

	public void hadDiarreia() {
		this.consulta.setDiarreia(true);
	}

	@Transactional
	public void createConsulta(ActionEvent evt) {

		FacesContext context = FacesContext.getCurrentInstance();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Date dataFormatada = null;
		try {
			dataFormatada = formato.parse(dataConsulta);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		consulta.setData(dataFormatada);
		try {

			EntityManagerImpl entityManager = new EntityManagerImpl();
			entityManager.insert(this.consulta);

			limparPaciente();
			context.addMessage(null, new FacesMessage("Cadastro efetuado", "Cadastro efetuado"));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Falha", "Não foi possível efetuar o cadastro"));
			e.printStackTrace();
		}

	}

	public void findConsultas() {
		EntityManagerImpl ent = new EntityManagerImpl();
		String query = "SELECT c FROM Consulta c where c.paciente =" + consulta.getPaciente().getId() + "ORDER BY data";
		consultas = ent.find(query);
	}

	public void createConsultaView() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("consulta", consulta);
	}

	public void onRowSelect(SelectEvent event) {
		EntityManagerImpl em = new EntityManagerImpl();
		Consulta selectedConsulta = (Consulta) event.getObject();
		consulta = (Consulta) em.findById(Consulta.class, selectedConsulta.getId());
	}

}
