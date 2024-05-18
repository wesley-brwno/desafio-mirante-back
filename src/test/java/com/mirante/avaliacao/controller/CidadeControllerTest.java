package com.mirante.avaliacao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mirante.avaliacao.dto.CidadeDTO;
import com.mirante.avaliacao.model.Cidade;
import com.mirante.avaliacao.service.ProjetoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CidadeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private ProjetoService projetoService;
    @InjectMocks
    private CidadeController cidadeController;

    @BeforeEach
    void setUp() {

    }
    @Test
    void pesquisarCidades() {
    }

    @Test
    void incluirCidade() {
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
        cidade.setNome("São Paulo");
        cidade.setUf("SP");
        cidade.setCapital(true);
        return cidade;
    }

    private CidadeDTO criaCidadeDtoValido() {
        return CidadeDTO.toDTO(criaCidadeValida());
    }
}