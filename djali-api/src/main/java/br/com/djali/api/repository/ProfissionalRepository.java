package br.com.djali.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.djali.api.model.Profissional;
@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {


	List<Profissional> findByNome(String nome);
//	List<Profissional> findByNomeContaining(String nome);
//	List<Profissional> findByEspecialidade(String nomeEspecialidade);
	
	

	
	@Query(value = "select *" + 
	        "from profissional " + 
	        "inner join especialidade " +
	        "on profissional.cod_especialidade = especialidade.cod_especialidade " , nativeQuery = true)
	List<Profissional> findAllByCodEspecialidade(@Param("codEspecialidade") String codEspecialidade);



	@Query(value = "SELECT * FROM Profissional  WHERE nome LIKE  %:nomeProfissional%" , nativeQuery = true)
	List<Profissional> findAllByNome(@Param("nomeProfissional") String nomeProfissional);
	
	
	

	
	

}
