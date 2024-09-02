package br.ufrn.imd;

import java.time.LocalDate;

/**
 * Classe que representa uma pessoa com informações pessoais básicas.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String estadoCivil;
    private int qtdFilhos;
    private Endereco endereco;

    /**
     * Construtor para a classe Pessoa.
     *
     * @param nome Nome da pessoa.
     * @param dataNascimento Data de nascimento da pessoa.
     * @param cpf CPF da pessoa.
     * @param estadoCivil Estado civil da pessoa.
     * @param qtdfilhos Quantidade de filhos da pessoa.
     * @param endereco Endereço residencial da pessoa.
     */
    public Pessoa(String nome, LocalDate dataNascimento, String cpf, String estadoCivil, Integer qtdfilhos, Endereco endereco){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
        this.qtdFilhos = qtdfilhos;
        this.endereco = endereco;
    }

    /**
     * Define o nome da pessoa.
     * @param nome Novo nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome da pessoa.
     * @return Nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define a data de nascimento da pessoa.
     * @param dataNascimento Nova data de nascimento da pessoa.
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna a data de nascimento da pessoa.
     * @return Data de nascimento da pessoa.
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define o CPF da pessoa.
     * @param cpf Novo CPF da pessoa.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o CPF da pessoa.
     * @return CPF da pessoa.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o estado civil da pessoa.
     * @param estadoCivil Novo estado civil da pessoa.
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * Retorna o estado civil da pessoa.
     * @return Estado civil da pessoa.
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * Define a quantidade de filhos da pessoa.
     * @param qtdFilhos Nova quantidade de filhos da pessoa.
     */
    public void setQtdFilhos(int qtdFilhos) {
        this.qtdFilhos = qtdFilhos;
    }

    /**
     * Retorna a quantidade de filhos da pessoa.
     * @return Quantidade de filhos da pessoa.
     */
    public int getQtdFilhos() {
        return qtdFilhos;
    }

    /**
     * Define o endereço residencial da pessoa.
     * @return Endereço residencial da pessoa.
     */
    public Endereco getEndereco() {
        return this.endereco;
    }

    /**
     * Define o endereço residencial da pessoa.
     * @param novoEndereco Novo endereço
     */
    public void setEndereco(Endereco novoEndereco) {
        this.endereco = novoEndereco;
    }
}
