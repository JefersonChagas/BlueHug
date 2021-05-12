package br.com.djali.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djali.api.model.Profissional;
import br.com.djali.api.model.Responsavel;
import br.com.djali.api.repository.ComentarioRepository;
import br.com.djali.api.repository.ResponsalvelRepository;

@RestController
@RequestMapping("/responsavel")
public class ResponsalvelController {

	
	@Autowired
	private ResponsalvelRepository responsalvelRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@GetMapping
	public List<Responsavel> getAll(){
		return responsalvelRepository.findAll();
	}
	@PostMapping
	public ResponseEntity<Responsavel> save(@RequestBody Responsavel responsavel) throws Exception {

		List<Responsavel> responsaveis = responsalvelRepository.findByNome(responsavel.getNome());

		try {

			if (responsaveis.isEmpty()) {
				return new ResponseEntity<Responsavel>(responsalvelRepository.save(responsavel), HttpStatus.CREATED);
				
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			//
//				if(profissionalService.validarCamposProfissional(profissional) == false) {
//					throw new Exception("Informações invalidas");
//				}
//			profissional.setCodEspecialidade(profissional.getCodEspecialidade());
			

		} catch (Exception e) {
			throw new Exception("Erro ao cadastrar" + e.getMessage());
		}

	}
	@PutMapping("/{codResponsavel}")
	public ResponseEntity<Responsavel> update(@PathVariable(value = "codResponsavel") Long codResponsavel,
			@RequestBody Responsavel responsavel) {
		Optional<Responsavel> verificaResponsavel = responsalvelRepository.findById(codResponsavel);

		if (!verificaResponsavel.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			responsavel.setCodResponsavel(verificaResponsavel.get().getCodResponsavel());
			return new ResponseEntity<Responsavel>(responsalvelRepository.save(responsavel), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{codResponsavel}")
	public ResponseEntity<?> delete(@PathVariable(value = "codResponsavel") Long codResponsavel) {
		Optional<Responsavel> verificaResponsavel = responsalvelRepository.findById(codResponsavel);
		List<Profissional> verificaComentarios = comentarioRepository.findAllByComentarios(codResponsavel);
		
		if(verificaComentarios.isEmpty() || verificaResponsavel.isPresent()) {
			responsalvelRepository.deleteById(codResponsavel);
		}
		
		if(verificaResponsavel.isPresent() ||!verificaComentarios.isEmpty() ) {
			comentarioRepository.deleteAllByComentario(codResponsavel);
			responsalvelRepository.deleteByComentarios(codResponsavel);
		}
		
		
		
		// Optional<Especialidade> verificaEspecialidade =
		// especialidadeRepository.findById(cod_profissional);

		if (!verificaResponsavel.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			responsalvelRepository.delete(verificaResponsavel.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
