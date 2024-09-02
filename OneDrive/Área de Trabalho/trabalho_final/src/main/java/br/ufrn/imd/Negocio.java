package br.ufrn.imd;

import java.time.LocalDate;

/**
 * Classe que representa um negócio, contendo informações sobre a empresa, proprietário e dados financeiros.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class Negocio {
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private LocalDate dataAbertura;
    private Pessoa proprietario;
    private Endereco endereco;
    private double faturamentoMensal;
    private double capitalInicial;

    /**
     * Construtor para criar um novo negócio.
     *
     * @param razaoSocial A razão social do negócio.
     * @param nomeFantasia O nome fantasia do negócio.
     * @param cnpj O CNPJ do negócio.
     * @param dataAbertura A data de abertura do negócio.
     * @param proprietario O proprietário do negócio.
     * @param endereco O endereço do negócio.
     * @param faturamentoMensal O faturamento mensal do negócio.
     * @param capitalInicial O capital inicial investido no negócio.
     */
    public Negocio(String razaoSocial, String nomeFantasia, String cnpj, LocalDate dataAbertura, Pessoa proprietario,
                   Endereco endereco, double faturamentoMensal, double capitalInicial){
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.dataAbertura = dataAbertura;
        this.proprietario = proprietario;
        this.endereco = endereco;
        this.faturamentoMensal = faturamentoMensal;
        this.capitalInicial = capitalInicial;
    }

    /**
     * Define o um novo valor para a razão social do negócio.
     * @param razaoSocial a nova razão social do negócio.
     */
    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }

    /**
     * Retorna o valor de razão social do negócio.
     * @return O valor de razão social do negócio.
     */
    public String getRazaoSocial(){
        return this.razaoSocial;
    }

    /**
     * Define um novo valor para o nome fantasia do negócio.
     * @param nomeFantasia o novo nome fantasia do negócio.
     */
    public void setNomeFantasia(String nomeFantasia){
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * Retorna o valor do nome fantasia do negócio.
     * @return O valor do nome fantasia do negócio.
     */
    public String getNomeFantasia(){
        return this.nomeFantasia;
    }

    /**
     * Define um novo valor para o CNPJ do negócio.
     * @param cnpj o novo CNPJ do negócio.
     */
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    /**
     * Retorna o valor do CNPJ do negócio.
     * @return O valor do CNPJ do negócio.
     */
    public String getCnpj(){
        return this.cnpj;
    }

    /**
     * Define um novo valor para a data de abertura do negocio.
     * @param dataAbertura a nova data de abertura do negocio.
     */
    public void setDataAbertura(LocalDate dataAbertura){
        this.dataAbertura = dataAbertura;
    }

    /**
     * Retorna o valor da data de abertura do negócio.
     * @return O valor da data de abertura do negócio.
     */
    public LocalDate getDataAbertura(){
        return this.dataAbertura;
    }

    /**
     * Define um novo proprietário do negócio.
     * @param proprietario o novo proprietário do negócio.
     */
    public void setProprietario(Pessoa proprietario){
        this.proprietario = proprietario;
    }

    /**
     * Retorna o proprietário do negócio.
     * @return O proprietário do negócio.
     */
    public Pessoa getProprietario(){
        return this.proprietario;
    }

    /**
     * Define um novo valor para o endereço do negócio.
     * @param novoEndereco o novo endereço do negócio.
     */
    public void setEndereco(Endereco novoEndereco){
        this.endereco = novoEndereco;
    }

    /**
     * Retorna o endereço do negócio.
     * @return O endereço do negócio.
     */
    public Endereco getEndereco(){
        return this.endereco;
    }

    /**
     * Define um novo valor para o faturamento mensal do negócio.
     * @param faturamentoMensal o novo faturamento mensal do negócio.
     */
    public void setFaturamentoMensal(double faturamentoMensal){
        this.faturamentoMensal = faturamentoMensal;
    }

    /**
     * Retorna o faturamento mensal do negócio.
     * @return O faturamento mensal do negócio.
     */
    public double getFaturamentoMensal(){
        return this.faturamentoMensal;
    }

    /**
     * Define um novo valor para o capital inicial do negócio.
     * @param capitalInicial o novo capital inicial do negócio.
     */
    public void setCapitalInicial(double capitalInicial){
        this.capitalInicial = capitalInicial;
    }

    /**
     * Retorna o capital inicial do negócio.
     * @return O capital inicial do negócio.
     */
    public double getCapitalInicial(){
        return this.capitalInicial;
    }
}
