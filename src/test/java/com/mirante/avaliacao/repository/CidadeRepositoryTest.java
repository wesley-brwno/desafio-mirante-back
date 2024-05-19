package com.mirante.avaliacao.repository;

import com.mirante.avaliacao.model.Cidade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;


@DataJpaTest
class CidadeRepositoryTest {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Test
    void findAll_DeveRetornarListDeCidade_QuandoBemSucedido() {
        List<Cidade> cidadeList = cidadeRepository.findAll();

        Assertions.assertThat(cidadeList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(10);
    }

    @Test
    void findById_DeveRetornarOptionalDeCidade_QuandoBemSucedido() {
        Long cidadeId = 1L;

        Optional<Cidade> cidadeOptional = cidadeRepository.findById(cidadeId);

        Assertions.assertThat(cidadeOptional)
                .isPresent()
                .isNotEmpty()
                .isExactlyInstanceOf(Optional.class);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void save_DevePersistirCidade_QuandoBemSucedido() {
        Cidade cidade = criaCidadeParaSerSalva();

        Cidade cidadeSalva = cidadeRepository.save(cidade);

        Assertions.assertThat(cidadeSalva).isNotNull();
        Assertions.assertThat(cidadeSalva.getId()).isGreaterThan(0);

        List<Cidade> cidadeList = cidadeRepository.findAll();

        Assertions.assertThat(cidadeList).contains(cidadeSalva);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void save_DeveAtualizarCidade_QuandoBemSucedido() {
        Cidade cidade = criaCidadeParaSerAtualizada();

        Cidade cidadeAtualizada = cidadeRepository.save(cidade);

        Assertions.assertThat(cidadeAtualizada).isNotNull();

        Optional<Cidade> cidadeOptional = cidadeRepository.findById(cidade.getId());

        Assertions.assertThat(cidadeAtualizada).isEqualTo(cidadeOptional.get());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void delete_DeveRemoverCidade_QuandoBemSucedido() {
        Long cidadeId = 1L;
        Cidade cidadeParaSerDeletada = cidadeRepository.findById(cidadeId).get();

        Assertions.assertThatCode(() -> cidadeRepository.delete(cidadeParaSerDeletada)).doesNotThrowAnyException();

        List<Cidade> cidadeList = cidadeRepository.findAll();

        Assertions.assertThat(cidadeList.contains(cidadeParaSerDeletada)).isFalse();
    }

    private Cidade criaCidadeParaSerSalva() {
        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setUf("AM");
        cidade.setCapital(true);
        return cidade;
    }

    private Cidade criaCidadeParaSerAtualizada() {
        Cidade cidade = new Cidade();
        cidade.setId(1L);
        cidade.setNome("Boa Vista");
        cidade.setUf("RR");
        cidade.setCapital(true);
        return cidade;
    }
}