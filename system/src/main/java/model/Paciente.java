package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Paciente {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private Long susCode;
	@Column
	private String nome;
	@Column
	@Convert(converter = SexoEnumConverter.class)
	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;
	@Column
	private String nomeResponsavel1;
	@Column
	private String nomeResponsavel2;
	@Column
	private Date dataNasc;
	@Column
	private String cidadeNasc;
	@Column
	private String estadoNasc;
	@ManyToOne(targetEntity = Endereco.class, cascade = CascadeType.ALL)
	private Endereco endereco;
	@Column
	private String telefone1;
	@Column
	private String telefone2;
	@Column
	private Double comprimentoNasc;
	@Column
	private Double pesoNasc;
	@Column
	private Double perimetroCefalicoNasc;
	@Column
	private Long apgarNasc;
	@Column
	private TipoParto tipoParto;
	@OneToMany(mappedBy = "paciente")
	private Set<Consulta> consultas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSusCode() {
		return susCode;
	}

	public void setSusCode(Long susCode) {
		this.susCode = susCode;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNomeResponsavel1() {
		return nomeResponsavel1;
	}

	public void setNomeResponsavel1(String nomeResponsavel1) {
		this.nomeResponsavel1 = nomeResponsavel1;
	}

	public String getNomeResponsavel2() {
		return nomeResponsavel2;
	}

	public void setNomeResponsavel2(String nomeResponsavel2) {
		this.nomeResponsavel2 = nomeResponsavel2;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCidadeNasc() {
		return cidadeNasc;
	}

	public void setCidadeNasc(String cidadeNasc) {
		this.cidadeNasc = cidadeNasc;
	}

	public String getEstadoNasc() {
		return estadoNasc;
	}

	public void setEstadoNasc(String estadoNasc) {
		this.estadoNasc = estadoNasc;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public Double getComprimentoNasc() {
		return comprimentoNasc;
	}

	public void setComprimentoNasc(Double comprimentoNasc) {
		this.comprimentoNasc = comprimentoNasc;
	}

	public Double getPesoNasc() {
		return pesoNasc;
	}

	public void setPesoNasc(Double pesoNasc) {
		this.pesoNasc = pesoNasc;
	}

	public Double getPerimetroCefalicoNasc() {
		return perimetroCefalicoNasc;
	}

	public void setPerimetroCefalicoNasc(Double perimetroCefalicoNasc) {
		this.perimetroCefalicoNasc = perimetroCefalicoNasc;
	}

	public Long getApgarNasc() {
		return apgarNasc;
	}

	public void setApgarNasc(Long apgarNasc) {
		this.apgarNasc = apgarNasc;
	}

	public TipoParto getTipoParto() {
		return tipoParto;
	}

	public void setTipoParto(TipoParto tipoParto) {
		this.tipoParto = tipoParto;
	}

	public Paciente(String nome, Sexo sexo) {
		super();
		this.nome = nome;
		this.sexo = sexo;
	}

	public Paciente() {
		super();
	}

}
