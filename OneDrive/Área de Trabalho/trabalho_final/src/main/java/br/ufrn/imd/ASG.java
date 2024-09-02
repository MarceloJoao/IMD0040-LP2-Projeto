package br.ufrn.imd;

import java.time.LocalDate;

/**
 * Classe que representa um ASG, estendendo a classe Pessoa e implementando a interface Funcionario.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class ASG extends Pessoa implements Funcionario{
    private float salario;
    private String matricula;
    private Cargo cargo;
    private LocalDate DataIngresso;
    private int diasFaltas;

    /**
     * Construtor para criar um novo ASG.
     *
     * @param nome Nome do ASG.
     * @param dataNascimento Data de nascimento do ASG.
     * @param cpf CPF do ASG.
     * @param estadoCivil Estado civil do ASG.
     * @param qtdfilhos Quantidade de filhos do ASG.
     * @param endereco Endereço do ASG.
     * @param salario Salário do ASG.
     * @param matricula Matrícula do ASG.
     * @param cargo Cargo do ASG.
     * @param dataIngresso Data de ingresso do ASG na empresa.
     */
    public ASG(String nome, LocalDate dataNascimento, String cpf, String estadoCivil, Integer qtdfilhos, Endereco endereco, float salario, String matricula, Cargo cargo, LocalDate dataIngresso){
        super(nome, dataNascimento, cpf, estadoCivil, qtdfilhos, endereco);
        this.salario = salario;
        this.matricula = matricula;
        this.cargo = cargo;
        this.DataIngresso = dataIngresso;
        this.diasFaltas = 0;
    }

    /**
     * Retorna o valor do salário do ASG.
     * @return O valor do salário do ASG.
     */
    @Override
    public float getSalario(){
        this.salario = calcularSalario(diasFaltas);
        return this.salario;
    }

    /**
     * Define o valor do salário do ASG.
     * @param salario O novo valor do ASG.
     */
    @Override
    public void setSalario(float salario){
        this.salario = salario;
    }

    /**
     * Retorna a matricula do ASG.
     * @return A matricula do ASG.
     */
    @Override
    public String getMatricula(){
        return this.matricula;
    }

    /**
     * Define a matricula do ASG.
     * @param matricula A nova matricula do ASG.
     */
    @Override
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    /**
     * Retorna a data de ingresso do ASG.
     * @return A data de ingresso do ASG.
     */
    @Override
    public LocalDate getDataIngresso(){
        return this.DataIngresso;
    }

    /**
     * Define a data de ingresso do ASG.
     * @param DataIngresso A nova data de ingresso do ASG.
     */
    @Override
    public void setDataIngresso(LocalDate DataIngresso){
        this.DataIngresso = DataIngresso;
    }

    /**
     * Retorna o tipo cargo do ASG.
     * @return O tipo cargo do ASG.
     */
    @Override
    public Cargo getCargo(){
        return this.cargo;
    }

    /**
     * Define o novo tipo cargo do ASG.
     * @param novoCargo O novo tipo de cargo do ASG.
     */
    @Override
    public void setCargo(Cargo novoCargo){
        this.cargo = novoCargo;
    }

    /**
     * Define os Dias de faltas do ASG.
     * @param diasFaltas quantidade de faltas do ASG.
     */
    public void setDiasFaltas(int diasFaltas){
        this.diasFaltas = diasFaltas;
    }

     /**
     * Retorna a quantidade de faltas do ASG.
     * @return Dias de faltas do ASG.
     */
    public int getDiasFaltas(){
        return this.diasFaltas;
    }

    /**
     * Calcula o salário do ASG com base no número de dias de falta.
     *
     * @param diasFaltas O número de dias que o ASG faltou.
     * @return O salário calculado após descontar as faltas e adicionar o bônus do cargo.
     */
    @Override
    public float calcularSalario(int diasFaltas){
        float desconto = (this.salario / 30) * diasFaltas;
        
        return(this.salario - desconto) * (1 + this.cargo.getBonus());
    }

    /**
     * Calcula a rescisão do contrato de trabalho do ASG.
     *
     * @param dataDesligamento A data de desligamento do ASG.
     * @return O valor da rescisão calculado com base no tempo de serviço.
     */
    @Override
    public float calcularRescisao(LocalDate dataDesligamento) {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(this.DataIngresso, dataDesligamento);

        return (dias / 365f) * this.salario;
    }
}
