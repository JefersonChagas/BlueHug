package br.com.djali.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codComentario;
	private String comentario;
	private Long codProfissional;
	private Long codResponsavel;
	
	
	public Comentario() {
		
	}

	public Comentario(String comentario, Long codProfissional, Long codResponsavel) {
		this.comentario = comentario;
		this.codProfissional = codProfissional;
		this.codResponsavel = codResponsavel;
				
		
	}

	public Long getCodComentario() {
		return codComentario;
	}

	public void setCodComentario(Long codComentario) {
		this.codComentario = codComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Long getCodProfissional() {
		return codProfissional;
	}

	public void setCodProfissional(Long codProfissional) {
		this.codProfissional = codProfissional;
	}

	public Long getCodResponsavel() {
		return codResponsavel;
	}

	public void setCodResponsavel(Long codResponsavel) {
		this.codResponsavel = codResponsavel;
	}


	
	

}
