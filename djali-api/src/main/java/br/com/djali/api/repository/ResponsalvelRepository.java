package br.com.djali.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.djali.api.model.Responsavel;

public interface ResponsalvelRepository extends JpaRepository<Responsavel, Long>{

	List<Responsavel> findByNome(String nome);
	
	@Query(value = "DELETE FROM Comentario WHERE "
			+ "exists("
			+ "Select * from Comentario c WHERE c.responsavel_id = :codResponsavel"
			+ ")" , nativeQuery = true)
	void deleteByComentarios(@Param("codResponsavel") Long codResponsavel);
	
	

}
