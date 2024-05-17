package com.mirante.avaliacao.service;

import com.mirante.avaliacao.model.Cidade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjetoServiceTest {

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
}