package br.ufrn.imd;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe que representa as finanças de um negócio, incluindo faturamento, despesas e capital.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class Financas {
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private double despesas;
    private double faturamentoMensal;
    private double capital;

    /**
     * Construtor para criar um novo conjunto de finanças para um negócio.
     *
     * @param razaoSocial A razão social do negócio.
     * @param nomeFantasia O nome fantasia do negócio.
     * @param cnpj O CNPJ do negócio.
     * @param faturamentoMensal O faturamento mensal do negócio.
     * @param capital O capital total do negócio.
     */
    public Financas(String razaoSocial, String nomeFantasia, String cnpj, double faturamentoMensal, double capital){
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.faturamentoMensal = faturamentoMensal;
        this.capital = capital;
        this.despesas = 0.0;
    }

    /**
     * Define um novo valor para a razão social do negócio.
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
     * Define um novo valor para o faturamento mensal do negócio.
     * @param faturamentoMensal o novo faturamento mensal do negócio.
     */
    public void setFaturamentoMensal(double faturamentoMensal){
        this.faturamentoMensal = faturamentoMensal;
    }

    /**
     * Retorna o valor do faturamento mensal do negócio.
     * @return O valor do faturamento mensal do negócio.
     */
    public double getFaturamentoMensal(){
        return this.faturamentoMensal;
    }

    /**
     * Define um novo valor para o capital do negócio.
     * @param capital o novo capital do negócio.
     */
    public void setCapital(double capital){
        this.capital = capital;
    }

    /**
     * Retorna o valor do capital do negócio.
     * @return O valor do capital do negócio.
     */
    public double getCapital(){
        return this.capital;
    }

    /**
     * Retorna o valor das despesas do negócio.
     * @return O valor das despesas do negócio.
     */
    public double getDespesas(){
        return this.despesas;
    }

    /**
     * Gera a folha de pagamento para uma lista de funcionários e grava em um arquivo CSV.
     *
     * @param funcionarios A lista de funcionários para calcular a folha de pagamento.
     */
    public void getFolhaDePagamento(List<Funcionario> funcionarios) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", new Locale("pt", "BR"));
        String mesAtual = LocalDate.now().format(formatter).toLowerCase();

        double totalDespesas = 0.0;
        StringBuilder planilha = new StringBuilder();

        // Cabecalho da planilha
        planilha.append("Razao Social: ").append(",")
                .append(this.razaoSocial).append(",")
                .append("Nome Fantasia: ").append(",")
                .append(this.nomeFantasia).append(",")
                .append("CNPJ: ").append(",")
                .append(this.cnpj).append(",")
                .append("\n");

        planilha.append("Folha de Pagamento do mes: " + mesAtual + "\n");

        // Conteudo da planilha
        planilha.append("\n");

        planilha.append("Matricula,Data de Entrada,Nome,CPF,Cargo,Salario\n");

        for (Funcionario funcionario : funcionarios) {
            totalDespesas += funcionario.getSalario();

            planilha.append(funcionario.getMatricula()).append(",")
                    .append(funcionario.getDataIngresso()).append(",")
                    .append(((Pessoa) funcionario).getNome()).append(",")
                    .append(((Pessoa) funcionario).getCpf()).append(",")
                    .append(funcionario.getCargo()).append(",")
                    .append(funcionario.getSalario())
                    .append("\n");
        }

        // Resultados
        planilha.append("\n");

        planilha.append("Total de Despesas: ,,,,,")
                .append(totalDespesas)
                .append("\n");

        planilha.append("Faturamento Mensal: ,,,,,")
                .append(this.faturamentoMensal)
                .append("\n");

        planilha.append("Saldo: ,,,,,")
                .append(this.faturamentoMensal - totalDespesas)
                .append("\n");

        String titulo = mesAtual + "-folha-de-pagamento-" + this.razaoSocial;
        gravarPlanilha(titulo, planilha.toString());

        this.despesas = totalDespesas;
    }

    /**
     * Grava a planilha de finanças em um arquivo CSV.
     *
     * @param titulo O título da planilha.
     * @param planilha O conteúdo da planilha em formato CSV.
     */
    private void gravarPlanilha(String titulo, String planilha){
        String homePath = System.getProperty("user.home");
        String arquivoPath = homePath + "/Downloads/" + titulo + ".csv";

        try (FileWriter fileWriter = new FileWriter(arquivoPath)) {
            fileWriter.write(planilha);
            System.out.println("Planilha criada!");

        } catch (IOException e) {
            System.err.println("Erro ao Criar a planilha: " + titulo + "Erro:" + e.getMessage());
        }
    }
}
