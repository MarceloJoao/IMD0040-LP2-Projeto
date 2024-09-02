package br.ufrn.imd;

import java.time.LocalDate;

/**
 * Classe que representa um vendedor, estendendo a classe Pessoa e implementando a interface Funcionario.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class Vendedor extends Pessoa implements Funcionario {
    private float salario;
    private String matricula;
    private Cargo cargo;
    private LocalDate dataIngresso;
    private int diasFaltas;

    /**
     * Construtor para criar um novo vendedor.
     *
     * @param nome Nome do vendedor.
     * @param dataNascimento Data de nascimento do vendedor.
     * @param cpf CPF do vendedor.
     * @param estadoCivil Estado civil do vendedor.
     * @param qtdfilhos Quantidade de filhos do vendedor.
     * @param endereco Endereço do vendedor.
     * @param salario Salário do vendedor.
     * @param matricula Matrícula do vendedor.
     * @param cargo Cargo do vendedor.
     * @param dataIngresso Data de ingresso do vendedor na empresa.
     */
    public Vendedor(String nome, LocalDate dataNascimento, String cpf, String estadoCivil, Integer qtdfilhos,
                    Endereco endereco, float salario, String matricula, Cargo cargo, LocalDate dataIngresso){
        super(nome, dataNascimento, cpf, estadoCivil, qtdfilhos, endereco);
        this.salario = salario;
        this.matricula = matricula;
        this.cargo = cargo;
        this.dataIngresso = dataIngresso;
        this.diasFaltas = 0;
    }

    /**
     * Retorna o valor do salário do vendedor.
     * @return O valor do salário do vendedor.
     */
    @Override
    public float getSalario() {
        this.salario = calcularSalario(diasFaltas);
        return this.salario;
    }

    /**
     * Define o valor do salário do vendedor.
     * @param salario O novo valor do salário do vendedor.
     */
    @Override
    public void setSalario(float salario) {
        this.salario = salario;
    }

    /**
     * Retorna a matricula do vendedor.
     * @return A matricula do vendedor.
     */
    @Override
    public String getMatricula() {
        return this.matricula;
    }

    /**
     * Define a matricula do vendedor.
     * @param matricula A nova matricula do vendedor.
     */
    @Override
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Retorna a data de ingresso do vendedor.
     * @return A data de ingresso do vendedor.
     */
    @Override
    public LocalDate getDataIngresso() {
        return this.dataIngresso;
    }

    /**
     * Define a data de ingresso do vendedor.
     * @param dataIngresso A nova data de ingresso do vendedor.
     */
    @Override
    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    /**
     * Retorna o tipo cargo do vendedor.
     * @return O tipo cargo do vendedor.
     */
    @Override
    public Cargo getCargo() {
        return this.cargo;
    }

    /**
     * Define o novo tipo cargo do vendedor.
     * @param novoCargo O novo tipo de cargo de vendedor.
     */
    @Override
    public void setCargo(Cargo novoCargo) {
        this.cargo = novoCargo;
    }
    
    /**
     * Define os Dias de faltas do vendedor.
     * @param diasFaltas quantidade de faltas do vendedor.
     */
    public void setDiasFaltas(int diasFaltas){
        this.diasFaltas = diasFaltas;
    }

     /**
     * Retorna a quantidade de faltas do do vendedor.
     * @return Dias de faltas do vendedor.
     */
    public int getDiasFaltas(){
        return this.diasFaltas;
    }

    /**
     * Calcula o salário do vendedor com base no número de dias de falta.
     *
     * @param diasFaltas O número de dias que o vendedor faltou.
     * @return O salário calculado após descontar as faltas e adiciona o bônus do cargo.
     */
    @Override
    public float calcularSalario(int diasFaltas) {
        float desconto = (this.salario / 30) * diasFaltas;

        return (this.salario - desconto) * (1 + this.cargo.getBonus());
    }

    /**
     * Calcula a rescisão do contrato de trabalho do vendedor.
     *
     * @param dataDesligamento A data de desligamento do vendedor.
     * @return O valor da rescisão calculado com base no tempo de serviço.
     */
    @Override
    public float calcularRescisao(LocalDate dataDesligamento) {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(this.dataIngresso, dataDesligamento);

        return (dias / 365f) * this.salario;
    }
}