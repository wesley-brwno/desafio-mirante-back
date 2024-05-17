package com.mirante.avaliacao.service;

import com.mirante.avaliacao.dto.CidadeDTO;
import com.mirante.avaliacao.model.Cidade;
import com.mirante.avaliacao.repository.CidadeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class ProjetoServiceTest {

    @Mock
    CidadeRepository cidadeRepository;

    @InjectMocks
    ProjetoService projetoService;

    Cidade cidadeValida;

    @BeforeEach
    void setUp() {
        cidadeValida = criaCidadeValida();
    }

    @Test
    void pesquisarCidades_DeveRetornarListDeCidadeDTO_QuandoBemSucedido() {
        BDDMockito.when(cidadeRepository.findAll()).thenReturn(List.of(cidadeValida));

        List<CidadeDTO> cidadeDTOS = projetoService.pesquisarCidades();

        Assertions.assertThat(cidadeDTOS)
                .isNotNull()
                .hasSize(1)
                .isInstanceOf(List.class);

        Assertions.assertThat(cidadeDTOS.get(0))
                .isEqualTo(criaCidadeDtoValido());
    }

    @Test
    void incluirCidade_DevePersistirCidadeSemLancarExceptions_QuandoBemSucedido() {
        BDDMockito.when(cidadeRepository.save(ArgumentMatchers.any(Cidade.class))).thenReturn(cidadeValida);
        CidadeDTO cidadeDTO = criaCidadeDtoParaSerSalvo();

        Assertions.assertThatCode(() -> projetoService.incluirCidade(cidadeDTO))
                .doesNotThrowAnyException();
    }

    @Test
    void alterarCidade_DeveAtualizarCidadeSemLancarExcptions_QuandoBemSuccedido() {
        BDDMockito.when(cidadeRepository.save(ArgumentMatchers.any(Cidade.class))).thenReturn(cidadeValida);
        BDDMockito.when(cidadeRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(cidadeValida));
        CidadeDTO cidadeDTO = criaCidadeDtoValido();

        Assertions.assertThatCode(() -> projetoService.alterarCidade(cidadeDTO))
                .doesNotThrowAnyException();
    }

    @Test
    void excluirCidade() {
    }

    private Cidade criaCidadeValida() {
        Cidade cidade = new Cidade();
        cidade.setId(1L);
        cidade.setNome("São Paulo");
        cidade.setUf("SP");
        cidade.setCapital(true);
        return cidade;
    }

    private Cidade criaCidadeParaSerSalva() {
        Cidade cidade = new Cidade();
        cidade.setNome("São Paulo");
        cidade.setUf("SP");
        cidade.setCapital(true);
        return cidade;
    }

    private CidadeDTO criaCidadeDtoValido() {
        return CidadeDTO.toDTO(criaCidadeValida());
    }

    private CidadeDTO criaCidadeDtoParaSerSalvo() {
        return CidadeDTO.toDTO(criaCidadeParaSerSalva());
    }
}