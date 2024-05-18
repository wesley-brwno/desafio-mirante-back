package com.mirante.avaliacao.service;

import java.util.List;

import com.mirante.avaliacao.model.Cidade;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mirante.avaliacao.dto.CidadeDTO;
import com.mirante.avaliacao.repository.CidadeRepository;
import org.springframework.transaction.annotation.Transactional;

//------------------------------------------------------------------
/** Service usado para acessar os repositórios da aplicação */
//------------------------------------------------------------------
@Service
@RequiredArgsConstructor
public class ProjetoService {

	private final CidadeRepository repository ;
	
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
	@Transactional
	public void incluirCidade(CidadeDTO dto) {
		repository.save(mapCidadeDtoParaEntidade(dto));
	}

	//----------------------------------------------------------
	/** Método chamado para alterar os dados de uma cidade */
	//----------------------------------------------------------
	@Transactional
	public void alterarCidade(CidadeDTO dto) {
		if (dto.getId() != null) {
			localizarCidadePorId(dto.getId());
			repository.save(mapCidadeDtoParaEntidade(dto));
		} else {
			throw new IllegalArgumentException("O ID da cidade não pode ser nulo");
		}
	}

	//----------------------------------------------------------
	/** Método chamado para excluir uma cidade */
	//----------------------------------------------------------
	@Transactional
	public void excluirCidade(Long idCidade) {
		Cidade cidade = localizarCidadePorId(idCidade);
		repository.delete(cidade);
	}

	private Cidade mapCidadeDtoParaEntidade(CidadeDTO cidadeDTO) {
		Cidade cidade = new Cidade();
		cidade.setId(cidadeDTO.getId());
		cidade.setNome(cidadeDTO.getNome());
		cidade.setUf(cidadeDTO.getUf());
		cidade.setCapital(cidadeDTO.getCapital());
		return cidade;
	}

	private Cidade localizarCidadePorId(Long id) {
		return repository.findById(id).orElseThrow(() ->
				new EntityNotFoundException("Cidade com id " + id + " não foi encontrada"));
	}
}
