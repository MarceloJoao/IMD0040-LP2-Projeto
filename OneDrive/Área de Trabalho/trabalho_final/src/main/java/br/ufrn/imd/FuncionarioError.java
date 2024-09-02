package br.ufrn.imd;
/**
 * Exceção personalizada que representa um erro de busca por um funcionário no sistema.
 *
 * @author João Marcelo de Souza
 */
public class FuncionarioError extends Exception {

    /**
     * Construtor da nova exceção FuncionarioError.
     * @param matricula A matricula do funcionário que causou o erro.
     */
    public FuncionarioError(String matricula){
        super("funcionario com a matricula" + matricula + "não encontrado");
    }
}
