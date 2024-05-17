package com.mirante.avaliacao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mirante.avaliacao.dto.CidadeDTO;
import com.mirante.avaliacao.repository.CidadeRepository;

//------------------------------------------------------------------
/** Service usado para acessar os repositórios da aplicação */
//------------------------------------------------------------------
@Service
public class ProjetoService {

	private CidadeRepository repository ;
	
	//---------------------------------------------------------
	/** Método que retorna todas as cidades cadastradas */
	//---------------------------------------------------------
	public List<CidadeDTO> pesquisarCidades() {
		return null;
	}

	//----------------------------------------------------------
	/** Método chamado para incluir uma nova cidade */
	//----------------------------------------------------------	
	public void incluirCidade(CidadeDTO dto) {    	
		
	}

	//----------------------------------------------------------
	/** Método chamado para alterar os dados de uma cidade */
	//----------------------------------------------------------	
	public void alterarCidade(CidadeDTO dto) {
				
	}

	//----------------------------------------------------------
	/** Método chamado para excluir uma cidade */
	//----------------------------------------------------------	
	public void excluirCidade(Long idCidade) {
		
	}
}
