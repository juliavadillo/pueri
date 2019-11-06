package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	@ManyToOne(targetEntity = Endereco.class, fetch = FetchType.LAZY)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	@Column
	private String telefone1;
	@Column
	private String telefone2;
	@Column
	private Float comprimentoNasc;
	@Column
	private Float pesoNasc;
	@Column
	private Float perimetroCefalicoNasc;
	@Column
	private Integer apgarNasc;
	@Column
	private TipoParto tipoParto;
	
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

	public Float getComprimentoNasc() {
		return comprimentoNasc;
	}
	public void setComprimentoNasc(Float comprimentoNasc) {
		this.comprimentoNasc = comprimentoNasc;
	}
	public Float getPesoNasc() {
		return pesoNasc;
	}
	public void setPesoNasc(Float pesoNasc) {
		this.pesoNasc = pesoNasc;
	}
	public Float getPerimetroCefalicoNasc() {
		return perimetroCefalicoNasc;
	}
	public void setPerimetroCefalicoNasc(Float perimetroCefalicoNasc) {
		this.perimetroCefalicoNasc = perimetroCefalicoNasc;
	}
	public Integer getApgarNasc() {
		return apgarNasc;
	}
	public void setApgarNasc(Integer apgarNasc) {
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
