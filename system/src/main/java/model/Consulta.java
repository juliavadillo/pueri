package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Consulta {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@ManyToOne
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;
	@Column
	private Double pesoAtual;
	@Column
	private Double alturaAtual;
	@Column
	private Date data;
	@Column
	private Double perimetroCefalico;
	@Column
	private boolean diarreia;
	@Column
	private boolean pneumonia;
	@Column
	private boolean hospitalizacao;
	@Column
	private boolean introducaoAli;

	@Column
	private String outros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Double getPesoAtual() {
		return pesoAtual;
	}

	public void setPesoAtual(Double pesoAtual) {
		this.pesoAtual = pesoAtual;
	}

	public Double getAlturaAtual() {
		return alturaAtual;
	}

	public void setAlturaAtual(Double alturaAtual) {
		this.alturaAtual = alturaAtual;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getPerimetroCefalico() {
		return perimetroCefalico;
	}

	public void setPerimetroCefalico(Double perimetroCefalico) {
		this.perimetroCefalico = perimetroCefalico;
	}

	public boolean isDiarreia() {
		return diarreia;
	}

	public void setDiarreia(boolean diarreia) {
		this.diarreia = diarreia;
	}

	public boolean isPneumonia() {
		return pneumonia;
	}

	public void setPneumonia(boolean pneumonia) {
		this.pneumonia = pneumonia;
	}

	public boolean isHospitalizacao() {
		return hospitalizacao;
	}

	public void setHospitalizacao(boolean hospitalizacao) {
		this.hospitalizacao = hospitalizacao;
	}

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
	}

	public boolean isIntroducaoAli() {
		return introducaoAli;
	}

	public void setIntroducaoAli(boolean introducaoAli) {
		this.introducaoAli = introducaoAli;
	}

}
