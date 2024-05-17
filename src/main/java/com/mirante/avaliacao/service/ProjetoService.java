package com.mirante.avaliacao.service;

import java.util.List;

import com.mirante.avaliacao.model.Cidade;
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
			List<Cidade> cidadeList = repository.findAll();
			return cidadeList.stream().map(CidadeDTO::toDTO).toList();
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

	private Cidade mapCidadeDtoParaEntidade(CidadeDTO cidadeDTO) {
		Cidade cidade = new Cidade();
		cidade.setId(cidadeDTO.getId());
		cidade.setNome(cidadeDTO.getNome());
		cidade.setUf(cidadeDTO.getUf());
		cidade.setCapital(cidadeDTO.getCapital());
		return cidade;
	}
}
