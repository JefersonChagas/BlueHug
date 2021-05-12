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

import br.com.djali.api.model.Comentario;
import br.com.djali.api.repository.ComentarioRepository;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@GetMapping
	public List<Comentario> getAll(){
		return comentarioRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Comentario> save(@RequestBody Comentario comentario) throws Exception {

	

		try {

			//
//				if(profissionalService.validarCamposProfissional(profissional) == false) {
//					throw new Exception("Informações invalidas");
//				}
//			profissional.setCodEspecialidade(profissional.getCodEspecialidade());
			return new ResponseEntity<Comentario>(comentarioRepository.save(comentario), HttpStatus.CREATED);

		} catch (Exception e) {
			throw new Exception("Erro ao cadastrar" + e.getMessage());
		}

	}
	
	@PutMapping("/{codComentario}")
	public ResponseEntity<Comentario> update(@PathVariable(value = "codComentario") Long codComentario,
			@RequestBody Comentario comentario) {
		Optional<Comentario> verificComentario = comentarioRepository.findById(codComentario);

		if (!verificComentario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			comentario.setCodComentario(verificComentario.get().getCodComentario());
			return new ResponseEntity<Comentario>(comentarioRepository.save(comentario), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{codComentario}")
	public ResponseEntity<?> delete(@PathVariable(value = "codComentario") Long codComentario) {
		Optional<Comentario> verificaComentario = comentarioRepository.findById(codComentario);
		// Optional<Especialidade> verificaEspecialidade =
		// especialidadeRepository.findById(cod_profissional);

		if (!verificaComentario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			comentarioRepository.delete(verificaComentario.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

}
