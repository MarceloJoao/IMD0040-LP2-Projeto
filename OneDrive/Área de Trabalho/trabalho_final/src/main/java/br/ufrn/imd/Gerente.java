package br.ufrn.imd;

import java.time.LocalDate;

/**
 * Classe que representa um gerente, estendendo a classe Pessoa e implementando a interface Funcionario.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class Gerente extends Pessoa implements Funcionario {
    private float salario;
    private float participacaoLucros;
    private String matricula;
    private Cargo cargo;
    private LocalDate dataIngresso;
    private int diasFaltas;

    /**
     * Construtor para criar um novo gerente.
     *
     * @param nome Nome do gerente.
     * @param dataNascimento Data de nascimento do gerente.
     * @param cpf CPF do gerente.
     * @param estadoCivil Estado civil do gerente.
     * @param qtdfilhos Quantidade de filhos do gerente.
     * @param endereco Endereço do gerente.
     * @param salario Salário do gerente.
     * @param matricula Matrícula do gerente.
     * @param cargo Cargo do gerente.
     * @param dataIngresso Data de ingresso do gerente na empresa.
     */
    public Gerente(String nome, LocalDate dataNascimento, String cpf, String estadoCivil, Integer qtdfilhos,
                   Endereco endereco, float salario, float participacaoLucros, String matricula, Cargo cargo, LocalDate dataIngresso) {
        super(nome, dataNascimento, cpf, estadoCivil, qtdfilhos, endereco);
        this.salario = salario;
        this.participacaoLucros = participacaoLucros;
        this.matricula = matricula;
        this.cargo = cargo;
        this.dataIngresso = dataIngresso;
        this.diasFaltas = 0;
    }

    /**
     * Retorna o valor do salário do gerente.
     * @return O valor do salário do gerente.
     */
    @Override
    public float getSalario() {
        this.salario = calcularSalario(diasFaltas);
        return this.salario;
    }

    /**
     * Define o valor do salário do gerente.
     * @param salario O novo valor do salário do gerente.
     */
    @Override
    public void setSalario(float salario) {
        this.salario = salario;
    }

    /**
     * Retorna a matricula do gerente.
     * @return A matricula do gerente.
     */
    @Override
    public String getMatricula() {
        return this.matricula;
    }

    /**
     * Define a matricula do gerente.
     * @param matricula A nova matricula do gerente.
     */
    @Override
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Retorna a data de ingresso do gerente.
     * @return A data de ingresso do gerente.
     */
    @Override
    public LocalDate getDataIngresso() {
        return this.dataIngresso;
    }

    /**
     * Define a data de ingresso do gerente.
     * @param dataIngresso A nova data de ingresso do gerente.
     */
    @Override
    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    /**
     * Retorna o tipo de cargo do gerente.
     * @return O tipo de cargo do gerente.
     */
    @Override
    public Cargo getCargo() {
        return this.cargo;
    }

    /**
     * Define o novo tipo de cargo do gerente.
     * @param novoCargo O novo cargo do gerente.
     */
    @Override
    public void setCargo(Cargo novoCargo) {
        this.cargo = novoCargo;
    }

    /**
     * Define os Dias de faltas do gerente.
     * @param diasFaltas quantidade de faltas do gerente.
     */
    public void setDiasFaltas(int diasFaltas){
        this.diasFaltas = diasFaltas;
    }

     /**
     * Retorna a quantidade de faltas do funcionario
     * @return Dias de faltas
     */
    public int getDiasFaltas(){
        return this.diasFaltas;
    }

    /**
     * Calcula o salário do gerente com base no número de dias de falta.
     *
     * @param diasFaltas O número de dias que o gerente faltou.
     * @return O salário calculado após descontar as faltas e adiciona a participação dos lucros.
     */
    @Override
    public float calcularSalario(int diasFaltas) {
        float desconto = (this.salario / 30) * diasFaltas;

        return (this.salario - desconto) + this.participacaoLucros;
    }

    /**
     * Calcula a rescisão do contrato de trabalho do gerente.
     *
     * @param dataDesligamento A data de desligamento do gerente.
     * @return O valor da rescisão calculado com base no tempo de serviço.
     */
    @Override
    public float calcularRescisao(LocalDate dataDesligamento) {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(this.dataIngresso, dataDesligamento);

        return (dias / 365f) * getSalario();
    }
}
