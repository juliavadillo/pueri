package control;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;

import model.DadosNascimento;
import model.Endereco;
import model.Paciente;
import model.Sexo;
@ManagedBean(value="paciente")
public class PacienteManagedBean implements java.io.Serializable {
	private static Logger log = Logger.getLogger(PacienteManagedBean.class);
	private static final long serialVersionUID = 1L;
	private Paciente paciente = new Paciente();
	private Endereco endereco = new Endereco();
	private DadosNascimento dadosNasc = new DadosNascimento();
	private String msg = "";
    private Sexo sexo;
	
    
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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

	public DadosNascimento getDadosNasc() {
		return dadosNasc;
	}

	public void setDadosNasc(DadosNascimento dadosNasc) {
		this.dadosNasc = dadosNasc;
	}

	public String getMsg() {
		return msg;
	}

	public void limparPaciente() {

		log.info("Limpando dados Paciente");
		this.paciente.setNome("");
		this.paciente.setNomeResponsavel1("");
		this.paciente.setNomeResponsavel2("");
		this.paciente.setCidadeNasc("");
		this.paciente.setEstadoNasc("");
		this.paciente.setSexo(null);
		this.endereco.setLogradouro("");
		this.endereco.setBairro("");
		this.endereco.setComplemento("");
		this.endereco.setNumero("");
		this.endereco.setCidade("");
		this.endereco.setUf("");
		this.endereco.setPais("");
		this.dadosNasc.setComprimento(null);
		this.dadosNasc.setPeso(null);
		this.dadosNasc.setPerimetroCefalico(null);
		this.dadosNasc.setApgar(null);
		this.dadosNasc.setTipoParto(null);
	}

	public String createPaciente() {

		String str = "index";

		try {

			EntityManagerImpl entityManager = new EntityManagerImpl();
			Endereco end = (Endereco) entityManager.insertObject(this.endereco);
			DadosNascimento dados = (DadosNascimento) entityManager.insertObject(this.dadosNasc);
			this.paciente.setEndereco(end);
			this.paciente.setDadosNasc(dados);
			entityManager.insert(this.paciente);

			limparPaciente();
			this.setMsg("Paciente cadastrado!");
		} catch (Exception e) {
			this.setMsg(e.getMessage());
			str = "insert";
			log.error(e);
		}

		return str;
	}

	private void setMsg(String message) {
		this.msg = message;
	}
}
