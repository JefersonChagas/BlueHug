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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.djali.api.model.Profissional;
import br.com.djali.api.repository.ProfissionalRepository;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

	@Autowired
	private ProfissionalRepository profissionalRepository;

	@GetMapping
	public ResponseEntity<List<Profissional>> getAll() {
		List<Profissional> profissionaisList = profissionalRepository.findAll();
		if (profissionaisList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Profissional>>(profissionaisList, HttpStatus.OK);
		}

	}
	@GetMapping("/nome")
	public ResponseEntity<List<Profissional>> getProfissionalNome(
			@RequestParam(value = "nome") String nome) {
		String var = nome;
		List<Profissional> profissionaisList = profissionalRepository.findAllByNome(nome);
		if (profissionaisList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Profissional>>(profissionaisList, HttpStatus.OK);
		}

	}

	@GetMapping("/esp")
	public ResponseEntity<List<Profissional>> getProfissionalEspecialidade(
			@RequestParam(value = "codEspecialidade") String codEspecialidade) {
		List<Profissional> profissionaisList = profissionalRepository.findAllByCodEspecialidade(codEspecialidade);
		if (profissionaisList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Profissional>>(profissionaisList, HttpStatus.OK);
		}

	}
	@GetMapping("/{id}")
	public ResponseEntity<Profissional> getId(@PathVariable(value = "id") Long codProfissional) {
		Optional<Profissional> profissional = profissionalRepository.findById(codProfissional);

		if (!profissional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Profissional>(profissional.get(), HttpStatus.OK);
		}

	}




	@PostMapping
	public ResponseEntity<Profissional> save(@RequestBody Profissional profissional) throws Exception {

		List<Profissional> profissionais = profissionalRepository.findByNome(profissional.getNome());

		try {

			if (!profissionais.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			//
//				if(profissionalService.validarCamposProfissional(profissional) == false) {
//					throw new Exception("Informações invalidas");
//				}
//			profissional.setCodEspecialidade(profissional.getCodEspecialidade());
			return new ResponseEntity<Profissional>(profissionalRepository.save(profissional), HttpStatus.CREATED);

		} catch (Exception e) {
			throw new Exception("Erro ao cadastrar" + e.getMessage());
		}

	}

	@PutMapping("/{codProfissional}")
	public ResponseEntity<Profissional> update(@PathVariable(value = "codProfissional") Long codProfissional,
			@RequestBody Profissional profissional) {
		Optional<Profissional> verificaProfissional = profissionalRepository.findById(codProfissional);

		if (!verificaProfissional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			profissional.setCodProfissional(verificaProfissional.get().getCodProfissional());
			return new ResponseEntity<Profissional>(profissionalRepository.save(profissional), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{codProfissional}")
	public ResponseEntity<?> delete(@PathVariable(value = "codProfissional") Long codProfissional) {
		Optional<Profissional> verificaProfissional = profissionalRepository.findById(codProfissional);
		// Optional<Especialidade> verificaEspecialidade =
		// especialidadeRepository.findById(cod_profissional);

		if (!verificaProfissional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			profissionalRepository.delete(verificaProfissional.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

}
