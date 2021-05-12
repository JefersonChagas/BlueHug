package br.com.djali.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "profissional")
public class Profissional implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProfissional;
	private String nome;
	private String crm;
	@OneToMany(mappedBy = "profissional", targetEntity = Endereco.class, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Endereco> endereco;
	private String email;
	private String whatsaap;
	private String telefone;
	private Long codEspecialidade;



	public Profissional() {

	}


	

	public Profissional(String nome, String crm, List<Endereco> endereco, String email, String whatsaap,
			String telefone, Long codEspecialidade) {
		this.nome = nome;
		this.crm = crm;
		this.endereco = endereco;
		this.email = email;
		this.whatsaap = whatsaap;
		this.telefone = telefone;
		this.codEspecialidade = codEspecialidade;
		
	}




	




	public Long getCodProfissional() {
		return codProfissional;
	}

	public void setCodProfissional(Long codProfissional) {
		this.codProfissional = codProfissional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhatsaap() {
		return whatsaap;
	}

	public void setWhatsaap(String whatsaap) {
		this.whatsaap = whatsaap;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public Long getCodEspecialidade() {
		return codEspecialidade;
	}

	public void setCodEspecialidade(Long codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProfissional == null) ? 0 : codProfissional.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		if (codProfissional == null) {
			if (other.codProfissional != null)
				return false;
		} else if (!codProfissional.equals(other.codProfissional))
			return false;
		return true;
	}

}
