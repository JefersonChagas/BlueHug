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

import br.com.djali.api.model.Especialidade;
import br.com.djali.api.repository.EspecialidadeRepository;
@RestController
@RequestMapping("/especialidades")
public class EspecilidadeController {
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@GetMapping
	public ResponseEntity<List<Especialidade>> getAllEspecialidades(){
		List<Especialidade> especialidadesList = especialidadeRepository.findAll();
		if(especialidadesList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Especialidade>>(especialidadesList, HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidade> getOneProfissionais(@PathVariable(value = "id")long cod_especialidade){
		Optional<Especialidade> especialidade = especialidadeRepository.findById(cod_especialidade);
		
		if(!especialidade.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Especialidade>(especialidade.get(), HttpStatus.OK);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Especialidade> saveEspecialidade( @RequestBody Especialidade especialidade){
		
		List<Especialidade> verificaEspecialidade = especialidadeRepository.findByNome(especialidade.getNome());
		
		
		if(!verificaEspecialidade.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Especialidade>(especialidadeRepository.save(especialidade), HttpStatus.CREATED);
		}
		
		
	}
	@PutMapping("/{cod_especialidade}")
	public ResponseEntity<Especialidade> updateEspecialidade(@PathVariable(value ="cod_especialidade") long cod_especialidade,
			@RequestBody Especialidade especialidade){
		Optional<Especialidade> verificaEspecialidade= especialidadeRepository.findById(cod_especialidade);
		
		if(!verificaEspecialidade.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else{
			especialidade.setCodEspecialidade(verificaEspecialidade.get().getCodEspecialidade());
			return new ResponseEntity<Especialidade>(especialidadeRepository.save(especialidade),HttpStatus.OK);
		}
	}

	@DeleteMapping("/{cod_especialidade}")
	public ResponseEntity<?> deleteEspecialidade(@PathVariable(value ="cod_especialidade") long cod_especialidade){
		Optional<Especialidade> verificaEspecialidade = especialidadeRepository.findById(cod_especialidade);
		
		if(!verificaEspecialidade.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else{
			especialidadeRepository.delete(verificaEspecialidade.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
