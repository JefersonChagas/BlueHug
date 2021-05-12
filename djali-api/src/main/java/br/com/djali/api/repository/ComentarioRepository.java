package br.com.djali.api.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.djali.api.model.Comentario;
import br.com.djali.api.model.Profissional;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{


	@Query(value = "Select * from Comentario WHERE responsavel_id = :codResponsavel" , nativeQuery = true)
	List<Profissional> findAllByComentarios(@Param("codResponsavel") Long codResponsavel);
	
	@Query(value = "Delete from Comentario WHERE responsavel_id = :codResponsavel" , nativeQuery = true)
	void deleteAllByComentario(Long codResponsavel);

	
	

	  


}
