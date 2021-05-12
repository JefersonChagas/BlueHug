package br.com.djali.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.djali.api.model.Especialidade;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade,Long>{

	List<Especialidade> findByNome(String nome);

	

}
