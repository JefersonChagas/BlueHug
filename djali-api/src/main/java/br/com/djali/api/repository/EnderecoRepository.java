package br.com.djali.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.djali.api.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	
//	@Query(value="SELECT cod_endereco FROM endereco WHERE profissional_cod_profissional = codProjeto",nativeQuery=true)
//	List<Endereco>  procuraEndereco (@Param("idProjeto")Long codProjeto);

}
