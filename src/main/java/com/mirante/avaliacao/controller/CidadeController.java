package com.mirante.avaliacao.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.avaliacao.dto.CidadeDTO;
import com.mirante.avaliacao.service.ProjetoService;

//--------------------------------------------------
/** Endpoint para consultar e manter cidades */
//--------------------------------------------------
@RestController
@CrossOrigin
@RequestMapping("/cidades")
public class CidadeController {

	private ProjetoService service ;
	
	//----------------------------------------------------------
	/** Endpoint que retorna todas as cidades cadastradas */
	//----------------------------------------------------------
	public List<CidadeDTO> pesquisarCidades() {
		// TODO: Responde GET em http://localhost:8080/mirante/cidades
		return null ;
	}
	
	//----------------------------------------------------------
	/** Endpoint para incluir nova cidade */
	//----------------------------------------------------------
	public void incluirCidade(@RequestBody(required = true) CidadeDTO cidade) {
		//	TODO: Responde POST em http://localhost:8080/mirante/cidades
		//	Envia JSON no body:
		//	{
		//	 	"nome": "Florianópolis",
		//	  	"uf": "SC",
		//	   	"capital": true
		//	}
	}	
	
	//----------------------------------------------------------
	/** Endpoint para alterar cidade */
	//----------------------------------------------------------
	public void alterarCidade(@RequestBody(required = true) CidadeDTO cidade) {
		// TODO: Responde PUT em http://localhost:8080/mirante/cidades
		//   Envia JSON no body:
		//   {
		//     "id": 11,
		//     "nome": "Blumenau",
		//     "uf": "SC",
		//     "capital": false
		//   }		 		
	}		
	
	//----------------------------------------------------------
	/** Endpoint para excluir uma cidade */
	//----------------------------------------------------------
	public void excluirCidade(@PathVariable(required = true) Long idCidade) {
		// Responde DELETE em http://localhost:8080/mirante/cidades/{idCidade}		
	}	
}
