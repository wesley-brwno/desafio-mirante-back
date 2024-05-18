package com.mirante.avaliacao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mirante.avaliacao.dto.CidadeDTO;
import com.mirante.avaliacao.model.Cidade;
import com.mirante.avaliacao.service.ProjetoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CidadeController.class)
class CidadeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProjetoService projetoService;

    private CidadeDTO cidadeDtoValido;

    @BeforeEach
    void setUp() {
        cidadeDtoValido = criaCidadeDtoValido();
    }

    @Test
    void pesquisarCidades_DeveRetornarListDeCidadesDTO_QuandoBemSucedido() throws Exception {
        BDDMockito.when(projetoService.pesquisarCidades()).thenReturn(List.of(cidadeDtoValido));

        mockMvc.perform(get("/cidades"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(List.of(criaCidadeDtoValido()))));
    }

    @Test
    void incluirCidade_DeveRetornarStatusHttp201Created_QuandoBemSuccedido() throws Exception {
        BDDMockito.doNothing().when(projetoService).incluirCidade(ArgumentMatchers.any(CidadeDTO.class));
        CidadeDTO cidadeDTO = criaCidadeDtoParaSerSalvo();

        mockMvc.perform(post("/cidades")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cidadeDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void alterarCidade() {
    }

    @Test
    void excluirCidade() {
    }

    private Cidade criaCidadeValida() {
        Cidade cidade = new Cidade();
        cidade.setId(1L);
        cidade.setNome("Manaus");
        cidade.setUf("AM");
        cidade.setCapital(true);
        return cidade;
    }

    private CidadeDTO criaCidadeDtoValido() {
        return CidadeDTO.toDTO(criaCidadeValida());
    }

    private CidadeDTO criaCidadeDtoParaSerSalvo() {
        Cidade cidade = criaCidadeValida();
        cidade.setId(null);
        return CidadeDTO.toDTO(cidade);
    }
}