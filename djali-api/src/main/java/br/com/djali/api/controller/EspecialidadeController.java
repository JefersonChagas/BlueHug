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
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.djali.api.model.Especialidade;
import br.com.djali.api.repository.EspecialidadeRepository;

@RequestMapping("/especialidades")
public class EspecialidadeController {
	

	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@GetMapping
	public List<Especialidade> getAll(){
		return especialidadeRepository.findAll();
	}
	
	@GetMapping("/{codEspecialidade}")
	public ResponseEntity<Especialidade> getId(@PathVariable Long codEspecialidade ){
		Optional<Especialidade> especialidade = especialidadeRepository.findById(codEspecialidade);
		
		if(especialidade.isPresent()) {
			return ResponseEntity.ok(especialidade.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<Especialidade>> save(@RequestBody Especialidade especialidade ) {
		List<Especialidade> especialidadeO =  especialidadeRepository.findAll();
		if (especialidadeO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Especialidade>>(especialidadeO, HttpStatus.OK);
		}
	}
	
	@PutMapping("/{codEspecialidade}")
	public ResponseEntity<Especialidade> update(@PathVariable Long codEspecialidade,
			@RequestBody Especialidade especialidade){
		
		Optional<Especialidade> verificaEspecialidade = especialidadeRepository.findById(codEspecialidade);

		if (!verificaEspecialidade.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			especialidade.setCodEspecialidade(verificaEspecialidade.get().getCodEspecialidade());
			return new ResponseEntity<Especialidade>(especialidadeRepository.save(especialidade), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{codEspecialidade}")
	public ResponseEntity<?>delete(@PathVariable Long codEspecialidade){
		if(especialidadeRepository.existsById(codEspecialidade) == false){
			return ResponseEntity.notFound().build();
		}
		especialidadeRepository.deleteById(codEspecialidade);
		
		return ResponseEntity.noContent().build();
	}
	
	
	

}
