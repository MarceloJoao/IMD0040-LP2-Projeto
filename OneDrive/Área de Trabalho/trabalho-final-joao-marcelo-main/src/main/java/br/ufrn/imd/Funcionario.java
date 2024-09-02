package br.ufrn.imd;

import java.time.LocalDate;

/**
 * Interface que define as operaçoes de funcionario.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public interface Funcionario {
    /**
     * Retorna o salário do funcionário.
     * @return O valor do salário.
     */
    float getSalario();

    /**
     * Define o salário do funcionário.
     * @param salario O novo valor do salário.
     */
    void setSalario(float salario);

    /**
     * Retorna a matricula do funcionário.
     * @return A matricula do funcionário.
     */
    String getMatricula();

    /**
     * Define a matricula do funcionário.
     * @param matricula A nova matricula do funcionário.
     */
    void setMatricula(String matricula);

    /**
     * Retorna a data de ingresso do funcionário.
     * @return A data de ingresso do funcionário.
     */
    LocalDate getDataIngresso();

    /**
     * Define a data de ingresso do funcionário.
     * @param dataIngresso A nova data de ingresso do funcionário.
     */
    void setDataIngresso(LocalDate dataIngresso);

    /**
     * Retorna o cargo do funcionário.
     * @return O cargo do funcionário.
     */
    Cargo getCargo();

    /**
     * Define o cargo do funcionário.
     * @param novoCargo O novo cargo do funcionário.
     */
    void setCargo(Cargo novoCargo);

    /**
     * Define os Dias de faltas do Funcionario
     * @param DiasFaltas quantidade de faltas do funcionario
     */
    void setDiasFaltas(int DiasFaltas);

    /**
     * Retorna a quantidade de faltas do funcionario
     * @return Dias de faltas
     */
    int getDiasFaltas();

    /**
     *  Retorna o salário do funcionário.
     * @param diasFaltas Quantidade de dias de faltas.
     * @return O valor do salário.
     */
    float calcularSalario(int diasFaltas);

    /**
     * Retorna o valor da rescisão do funcionário.
     * @param dataDesligamento A data de desligamento do funcionário.
     * @return O valor da rescisão.
     */
    float calcularRescisao(LocalDate dataDesligamento);

}
