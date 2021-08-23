package com.tdd.junit.udemy;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoasTest {

    @Test
    @DisplayName("Deve cadastrar uma pessoa quando tudo der certo")
    void deveCriarOCadastroDePessoas(){
        // cenário e execução
        CadastroPessoas cadastro = new CadastroPessoas();

        //verificação
        BDDAssertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa quando tudo der certo")
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
    @DisplayName("Não deve adicionar uma pessoa quando o nome não for informado")
    void naoDeveAdicionarPessoaComNomeVazio(){
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        Assertions.assertThrows(PessoaSemNomeException.class,
        ()->cadastroPessoas.adicionar(pessoa));
    }

    @Test
    @DisplayName("Deve remover uma pessoa quando tudo ocorrer bem")
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
    @DisplayName("Deve lançar uma exceção ao tentar remover uma pessoa inexistente")
    void deveLancarErroAoTentarRemoverPessoaInexistente(){
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        Assertions.assertThrows(CadastroVazioEzception.class, ()->cadastroPessoas.remover(pessoa));


    }
}
