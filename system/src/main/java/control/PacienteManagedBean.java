package control;

import java.util.Arrays;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

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
	private Sexo sexo;
	private TipoParto tipoParto;

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
		this.paciente.setTelefone1("");
		this.paciente.setTelefone2("");
		this.endereco.setLogradouro("");
		this.endereco.setBairro("");
		this.endereco.setComplemento("");
		this.endereco.setNumero("");
		this.endereco.setCidade("");
		this.endereco.setUf("");
		this.endereco.setPais("");
	}

	@Transactional
	public String createPaciente() {

		String str = "index";

		try {

			EntityManagerImpl entityManager = new EntityManagerImpl();
			Endereco end = (Endereco) entityManager.insertObject(this.endereco);
			this.paciente.setEndereco(end);
			this.paciente.setSexo(sexo);
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
