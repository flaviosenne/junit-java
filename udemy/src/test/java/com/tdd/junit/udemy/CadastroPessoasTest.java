package com.tdd.junit.udemy;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CadastroPessoasTest {

    @Test
    void deveCriarOCadastroDePessoas(){
        // cenário e execução
        CadastroPessoas cadastro = new CadastroPessoas();

        //verificação
        BDDAssertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    void deveAdicionarUmaPessoa(){
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joao");

        cadastroPessoas.adicionar(pessoa);

        BDDAssertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test
    void naoDeveAdicionarPessoaComNomeVazio(){
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        Assertions.assertThrows(PessoaSemNomeException.class,
        ()->cadastroPessoas.adicionar(pessoa));
    }

    @Test
    void deveRemoverUmaPessoa(){
        // cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joao");
        cadastroPessoas.adicionar(pessoa);

        // execução
        cadastroPessoas.remover(pessoa);

        //verificação
        BDDAssertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();

    }

    @Test
    void deveLancarErroAoTentarRemoverPessoaInexistente(){
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        Assertions.assertThrows(CadastroVazioEzception.class, ()->cadastroPessoas.remover(pessoa));


    }
}
