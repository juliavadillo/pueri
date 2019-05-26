package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DadosNascimento {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private Long comprimento;
	@Column
	private Long peso;
	@Column
	private Long perimetroCefalico;
	@Column
	private Integer apgar;
	@Column
	private TipoParto tipoParto;

	@OneToOne(mappedBy = "dadosNasc")
	private Paciente paciente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getComprimento() {
		return comprimento;
	}

	public void setComprimento(Long comprimento) {
		this.comprimento = comprimento;
	}

	public Long getPeso() {
		return peso;
	}

	public void setPeso(Long peso) {
		this.peso = peso;
	}

	public Long getPerimetroCefalico() {
		return perimetroCefalico;
	}

	public void setPerimetroCefalico(Long perimetroCefalico) {
		this.perimetroCefalico = perimetroCefalico;
	}

	public Integer getApgar() {
		return apgar;
	}

	public void setApgar(Integer apgar) {
		this.apgar = apgar;
	}

	public TipoParto getTipoParto() {
		return tipoParto;
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
}
