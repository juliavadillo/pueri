package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

import model.Endereco;
import model.Paciente;
import model.Sexo;
import model.TipoParto;

@ManagedBean(value = "paciente")

public class PacienteManagedBean implements java.io.Serializable {
	private static Logger log = Logger.getLogger(PacienteManagedBean.class);
	private static final long serialVersionUID = 1L;
	private Paciente paciente = new Paciente();
	private Endereco endereco = new Endereco();
	private String msg = "";
	private TipoParto tipoParto;
	private List<Paciente> pacientes = new ArrayList<>();
	private String nomeBusca = "";
	
	

	public String getNomeBusca() {
		return nomeBusca;
	}

	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<TipoParto> getParto() {
		return Arrays.asList(TipoParto.values());
	}

	public TipoParto getTipoParto() {
		return tipoParto;
	}

	public List<Sexo> getGenders() {
		return Arrays.asList(Sexo.values());
	}

	public void setTipoParto(TipoParto tipoParto) {
		this.tipoParto = tipoParto;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getMsg() {
		return msg;
	}

	public void limparPaciente() {

		log.info("Limpando dados Paciente");
		this.paciente.setNome("");
		this.paciente.setSusCode(null);
		this.paciente.setNomeResponsavel1("");
		this.paciente.setNomeResponsavel2("");
		this.paciente.setCidadeNasc("");
		this.paciente.setEstadoNasc("");
		this.paciente.setSexo(null);
		this.paciente.setTelefone1("");
		this.paciente.setTelefone2("");
		this.paciente.setTipoParto(null);
		this.paciente.setComprimentoNasc(null);
		this.paciente.setPesoNasc(null);
		this.paciente.setApgarNasc(null);
		this.paciente.setPerimetroCefalicoNasc(null);
		this.endereco.setLogradouro("");
		this.endereco.setBairro("");
		this.endereco.setComplemento("");
		this.endereco.setNumero("");
		this.endereco.setCidade("");
		this.endereco.setUf("");
		this.endereco.setPais("");
	}

	@Transactional
	public void createPaciente(ActionEvent evt) {

		FacesContext context = FacesContext.getCurrentInstance();
		try {

			EntityManagerImpl entityManager = new EntityManagerImpl();
			this.paciente.setEndereco(endereco);
			entityManager.insert(this.paciente);

			limparPaciente();
			context.addMessage(null, new FacesMessage("Cadastro efetuado", "Cadastro efetuado"));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Falha", "Não foi possível efetuar o cadastro"));
			e.printStackTrace();
		}

	}
	
	public void createConsulta() {	
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("paciente", this.paciente);
		 
	}
	
	public void findAllPacients() {
		pacientes.clear();
		EntityManagerImpl em = new EntityManagerImpl();
		String query = "SELECT p FROM Paciente p";
	    pacientes.addAll(em.find(query));
	}
	
	public void findPaciente() {
		EntityManagerImpl em = new EntityManagerImpl();
		String query = "SELECT p FROM Paciente p where p.nome like '%"+nomeBusca+"%'";
		pacientes.clear();
		pacientes.addAll(em.find(query));
	}
	@Transactional
	public void removerPaciente() {
		FacesContext context = FacesContext.getCurrentInstance();
		EntityManagerImpl em = new EntityManagerImpl();
		Paciente pac = (Paciente) em.findById(Paciente.class, this.paciente.getId());		
		em.remove(pac);
		context.addMessage(null, new FacesMessage("Cadastro removido", "Cadastro efetuado"));
		findAllPacients();
		
	}
	
	public void onRowSelect(SelectEvent event) {
		EntityManagerImpl em = new EntityManagerImpl();
		Paciente selectedPaciente = (Paciente) event.getObject();
		Paciente pac = (Paciente) em.findById(Paciente.class,selectedPaciente.getId());
		Endereco end = (Endereco) em.findById(Endereco.class, pac.getEndereco().getId());
        setPaciente(pac);
        setEndereco(end);
    }
	@Transactional
	public void updatePaciente() {
		FacesContext context = FacesContext.getCurrentInstance();
		EntityManagerImpl entityManager = new EntityManagerImpl();
		this.paciente.setEndereco(endereco);
		entityManager.update(this.paciente);
		context.addMessage(null, new FacesMessage("Cadastro Atualizado", "Cadastro Atualizado"));
	}

}
