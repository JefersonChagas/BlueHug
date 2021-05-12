package br.com.djali.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djali.api.model.Endereco;
import br.com.djali.api.model.Especialidade;
import br.com.djali.api.model.Profissional;
import br.com.djali.api.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	private EnderecoRepository enderecoRepository ;

	
	@GetMapping
	public ResponseEntity<List< Endereco>> getAllEnderecos() {
		List<Endereco> enderecoList = enderecoRepository.findAll();
		if (enderecoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List< Endereco>>(enderecoList, HttpStatus.OK);
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getOneEndereco(@PathVariable(value = "id") long codEndereco) {
		Optional<Endereco> endereco = enderecoRepository.findById(codEndereco);

		if (!endereco.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);
		}

	}
	@PostMapping
	public ResponseEntity<Endereco> saveEndereco( @RequestBody Endereco endereco){
		
		
			return new ResponseEntity<Endereco>(enderecoRepository.save(endereco), HttpStatus.CREATED);
		
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEndereco(@PathVariable(value = "id") long codEndereco) {
		Optional<Endereco> verificaEndereco = enderecoRepository.findById(codEndereco);
		// Optional<Especialidade> verificaEspecialidade =
		// especialidadeRepository.findById(cod_profissional);

		if (!verificaEndereco.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			enderecoRepository.delete(verificaEndereco.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	

	

	
}
