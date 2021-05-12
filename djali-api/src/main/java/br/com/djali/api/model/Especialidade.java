package br.com.djali.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="especialidade")
public class Especialidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codEspecialidade;
	private String nome;
	private String descricao;



	public Long getCodEspecialidade() {
		return codEspecialidade;
	}
	public void setCodEspecialidade(Long codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEspecialidade == null) ? 0 : codEspecialidade.hashCode());
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
		Especialidade other = (Especialidade) obj;
		if (codEspecialidade == null) {
			if (other.codEspecialidade != null)
				return false;
		} else if (!codEspecialidade.equals(other.codEspecialidade))
			return false;
		return true;
	}

	
	
}