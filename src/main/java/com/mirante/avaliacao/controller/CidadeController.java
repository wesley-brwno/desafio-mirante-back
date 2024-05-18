package com.mirante.avaliacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.mirante.avaliacao.dto.CidadeDTO;
import com.mirante.avaliacao.service.ProjetoService;
import lombok.RequiredArgsConstructor;
//--------------------------------------------------
/** Endpoint para consultar e manter cidades */
//--------------------------------------------------
@RestController
@CrossOrigin
@RequestMapping("/cidades")
@RequiredArgsConstructor
public class CidadeController {

	private final ProjetoService service ;
	
	//----------------------------------------------------------
	/** Endpoint que retorna todas as cidades cadastradas */
	//----------------------------------------------------------
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CidadeDTO> pesquisarCidades() {
		return service.pesquisarCidades() ;
	}
	
	//----------------------------------------------------------
	/** Endpoint para incluir nova cidade */
	//----------------------------------------------------------
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void incluirCidade(@RequestBody(required = true) CidadeDTO cidade) {
		service.incluirCidade(cidade);
	}	
	
	//----------------------------------------------------------
	/** Endpoint para alterar cidade */
	//----------------------------------------------------------
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void alterarCidade(@RequestBody(required = true) CidadeDTO cidade) {
		service.alterarCidade(cidade);
	}		
	
	//----------------------------------------------------------
	/** Endpoint para excluir uma cidade */
	//----------------------------------------------------------
	public void excluirCidade(@PathVariable(required = true) Long idCidade) {
		// Responde DELETE em http://localhost:8080/mirante/cidades/{idCidade}		
	}	
}
