package br.ufrn.imd;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe que representa uma empresa, estendendo a classe Negocio e gerencia funcionários e finanças.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class Empresa extends Negocio{
    private List<Funcionario> funcionarios;
    private Financas financas;

    /**
     * Construtor para criar uma nova empresa.
     *
     * @param razaoSocial A razão social da empresa.
     * @param nomeFantasia O nome fantasia da empresa.
     * @param cnpj O CNPJ da empresa.
     * @param dataAbertura A data de abertura da empresa.
     * @param proprietario O proprietário da empresa.
     * @param endereco O endereço da empresa.
     * @param faturamentoMensal O faturamento mensal da empresa.
     * @param capitalInicial O capital inicial da empresa.
     */
    public Empresa(String razaoSocial, String nomeFantasia, String cnpj, LocalDate dataAbertura, Pessoa proprietario, Endereco endereco, double faturamentoMensal, double capitalInicial) {
        super(razaoSocial, nomeFantasia, cnpj, dataAbertura, proprietario, endereco, faturamentoMensal, capitalInicial);
        this.funcionarios = new ArrayList<>();
        this.financas = new Financas(razaoSocial, nomeFantasia, cnpj, faturamentoMensal, capitalInicial);
    }

    /**
     * Adiciona um funcionário à lista de funcionários da empresa.
     *
     * @param funcionario O funcionário a ser adicionado.
     */
    public void adicionarFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    /**
     * Demite um funcionário com base na sua matrícula.
     *
     * @param matricula A matrícula do funcionário a ser demitido.
     */
    public float demitirFuncionario(String matricula) {
        float recisao = 0;
        try{
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getMatricula().equals(matricula)) {
                    recisao = funcionario.calcularRescisao(LocalDate.now());

                    funcionarios.remove(funcionario);
                    System.out.println("Funcionário demitido");

                    return recisao;
                }
            }
            throw new FuncionarioError(matricula);
        }catch (FuncionarioError e) {
            System.err.println("Erro ao demitir funcionário: " + e.getMessage());

            return recisao;
        }
    }

    /**
     * Busca um funcionário com base na sua matrícula.
     *
     * @param matricula A matrícula do funcionário a ser buscado.
     * @return O funcionário encontrado.
     */
    public Funcionario buscarFuncionario(String matricula) {
       try{
           for (Funcionario funcionario : funcionarios) {
               if (funcionario.getMatricula().equals(matricula)) {
                   System.out.println("funcionario encontrado");
                   return funcionario;
               }
           }
           throw new FuncionarioError(matricula);
       }catch (FuncionarioError e){
           System.err.println("Funcionario não encontrado" + e.getMessage());
           return null;
       }
    }

    /**
     * Gera a folha de pagamento para todos os funcionários da empresa.
     */
    public void gerarFolhaDePagamento(){
        System.out.println("Gerando folha de pagamento...");
        financas.getFolhaDePagamento(funcionarios);
    }
}

