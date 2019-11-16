package control;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import model.Consulta;
import model.Paciente;

@ManagedBean(value = "consulta")
@RequestScoped
public class ConsultaManagedBean implements java.io.Serializable {
	private static Logger log = Logger.getLogger(ConsultaManagedBean.class);
	private static final long serialVersionUID = 1L;
	private Consulta consulta;
	
	
	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	@PostConstruct
	public void initialize() {
		consulta = new Consulta();
		consulta.setPaciente((Paciente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("paciente"));
	}

	public void limparPaciente() {

		log.info("Limpando dados Consulta");
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

	@Transactional
	public void createConsulta(ActionEvent evt) {

		FacesContext context = FacesContext.getCurrentInstance();
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

}
