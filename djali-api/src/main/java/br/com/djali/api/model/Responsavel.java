package br.com.djali.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "responsavel")
public class Responsavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codResponsavel;
	private String nome;
	private String sobrenome;
	private String cidade;
	private String estado;
	
	
	
	public Responsavel() {

	}
	
	public Responsavel(String nome, String sobrenome, String cidade, String estado) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Long getCodResponsavel() {
		return codResponsavel;
	}
	public void setCodResponsavel(Long codResponsavel) {
		this.codResponsavel = codResponsavel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	

}
