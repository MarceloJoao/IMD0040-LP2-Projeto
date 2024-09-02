package br.ufrn.imd;

//import br.ufrn.imd.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Sistema de gerenciamento de uma empresa baseado no projeto criado no trabalho final da materia de LPI.
 *
 * @author João Marcelo de Souza
 * @author José Manoel Freitas da Silva
 */
public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Scanner scanner = new Scanner(System.in);
    private static Empresa empresa;

    public static void main(String[] args) throws IOException {
        criarEmpresa();
        executarMenu();
    }

    /**
     * Exibe o menu de opções do programa.
     */
    private static void exibirMenu() {
        System.out.println("Escolha uma opcao:");
        System.out.println("1)- Adicionar Funcionario");
        System.out.println("2)- Buscar Funcionario");
        System.out.println("3)- Demitir Funcionario");
        System.out.println("4)- Gerar Folha de Pagamento");
        System.out.println("5)- Sair");
    }

    /**
     * Executa o menu de opções do programa.
     * @throws IOException caso ocorra algum erro na leitura dos dados.
     */
    private static void executarMenu() throws IOException {
        System.out.println("**********************************************************");
        System.out.println("Bem-vindo a Empresa " + empresa.getNomeFantasia());
        System.out.println(empresa.getRazaoSocial() + " | CNPJ: " + empresa.getCnpj());
        System.out.println("**********************************************************" + "\n");

        while(true){
            exibirMenu();
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    buscarFuncionario();
                    break;
                case 3:
                    demitirFuncionario();
                    break;
                case 4:
                    gerarFolhaDePagamento();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        }
    }

    /**
     * Cria um novo endereço valido.
     * @return O novo endereço.
     * @throws IOException caso ocorra algum erro na leitura dos dados.
     */
    private static Endereco criarEndereco() throws IOException {
        System.out.println("Adicione um endereco valido: ");

        System.out.println("Informe o logradouro da rua: ");
        String rua = reader.readLine();

        System.out.println("Informe o nome do bairro: ");
        String bairro = reader.readLine();

        System.out.println("Informe a cidade e o estado (Cidade-ES): ");
        String cidade = reader.readLine();

        System.out.println("Informe o numero do local: ");
        int numero = scanner.nextInt();

        return new Endereco(rua, bairro, cidade, numero);
    }

    /**
     * Cria uma data valida.
     * @return A nova data.
     */
    private static LocalDate criarData() {
        System.out.println("Insira uma data valida: ");

        System.out.println("Digite o ano: ");
        int ano = scanner.nextInt();

        System.out.println("Digite o mes: ");
        int mes = scanner.nextInt();

        System.out.println("Digite o dia: ");
        int dia = scanner.nextInt();

        return LocalDate.of(ano, mes, dia);
    }

    /**
     * Cria uma pessoa valida.
     * @return A nova pessoa.
     * @throws IOException caso ocorra algum erro na leitura dos dados.
     */
    private static Pessoa criarPessoa() throws IOException {
        System.out.println("Informe o nome: ");
        String nome = reader.readLine();

        System.out.println("Insira a data de nascimento: ");
        LocalDate dataNascimento = criarData();

        System.out.println("Insira o CPF: ");
        String cpf = scanner.next();

        System.out.println("Informe o estado civil: ");
        String estadoCivil = scanner.next();

        System.out.println("Informe a quantidade de filhos: ");
        int filhos = scanner.nextInt();

        System.out.println("Informe um endereco: ");
        Endereco endereco = criarEndereco();

        return new Pessoa(nome, dataNascimento, cpf, estadoCivil, filhos, endereco);
    }

    /**
     * Inicializa uma empresa com um dono e data de criacao validos.
     * @throws IOException caso ocorra algum erro na leitura dos dados.
     */
    private static void criarEmpresa() throws IOException {
        System.out.println("Digite os detalhes do proprietario da empresa:");
        Pessoa proprietario = criarPessoa();

        System.out.println("Digite o endereco da empresa:");
        Endereco enderecoEmpresa = criarEndereco();

        System.out.println("Digite a razao social da empresa:");
        String razaoSocial = reader.readLine();

        System.out.println("Digite o nome fantasia da empresa:");
        String nomeFantasia = reader.readLine();

        System.out.println("Digite o CNPJ da empresa:");
        String cnpj = reader.readLine();

        System.out.println("Digite a data de abertura da empresa:");
        LocalDate dataAbertura = criarData();

        System.out.println("Digite o faturamento mensal da empresa:");
        double faturamentoMensal = scanner.nextDouble();

        System.out.println("Digite o capital inicial da empresa:");
        double capitalInicial = scanner.nextDouble();

        empresa = new Empresa(razaoSocial, nomeFantasia, cnpj, dataAbertura, proprietario, enderecoEmpresa, faturamentoMensal, capitalInicial);
    }

    /**
     * Cria um cargo valido que pode ser utilizado na criacao de um funcionario.
     * @return Um cargo valido.
     */
    private static Cargo criarCargo() {
        System.out.println("Informe um cargo valido: ");
        System.out.println("1-ASG");
        System.out.println("2-Vendedor A");
        System.out.println("3-Vendedor B");
        System.out.println("4-Vendedor C");
        System.out.println("5-Gerente");

        int tipoFuncionario = scanner.nextInt();

        switch (tipoFuncionario) {
            case 1:
                return Cargo.ASG;
            case 2:
                return Cargo.VENDEDOR_A;
            case 3:
                return Cargo.VENDEDOR_B;
            case 4:
                return Cargo.VENDEDOR_C;
            case 5:
                return Cargo.GERENTE;
            default:
                System.out.println("Tipo nao localizado");
                return null;
        }
    }

    /**
     * Gera uma matricula aleatoria.
     * @return A nova matricula.
     */
    private static String gerarMatricula() {
        Random randomInterger = new Random();
        return ("MAT-" + randomInterger.nextInt(99999));
    }

    /**
     * Metodo responsavel por adicionar um novo funcionario valido na empresa, com um cargo predefinido no enum Cargo  .
     * @throws IOException caso ocorra algum erro na leitura dos dados.
     */
    private static void adicionarFuncionario() throws IOException {
        Funcionario funcionario;
        System.out.println("Adicione as informacoes do novo funcionario: ");
        Pessoa pessoa = criarPessoa();

        System.out.println("Insira o cargo do funcionario: ");
        Cargo cargo = criarCargo();

        System.out.println("Insira a data de admissao: ");
        LocalDate dataAdmissao = criarData();

        System.out.println("Insira o valor do salario: ");
        float valorSalario = scanner.nextFloat();

        if (cargo == Cargo.ASG) {
            funcionario = new ASG(pessoa.getNome(),
                    pessoa.getDataNascimento(),
                    pessoa.getCpf(),
                    pessoa.getEstadoCivil(),
                    pessoa.getQtdFilhos(),
                    pessoa.getEndereco(),
                    valorSalario,
                    gerarMatricula(),
                    cargo,
                    dataAdmissao);
        } else if (cargo == Cargo.GERENTE) {
            System.out.println("Informe o valor da participacao nos lucros: ");
            float participacaoLucros = scanner.nextFloat();

            funcionario = new Gerente(pessoa.getNome(),
                    pessoa.getDataNascimento(),
                    pessoa.getCpf(),
                    pessoa.getEstadoCivil(),
                    pessoa.getQtdFilhos(),
                    pessoa.getEndereco(),
                    valorSalario,
                    participacaoLucros,
                    gerarMatricula(),
                    cargo,
                    dataAdmissao);
        } else {
            funcionario = new Vendedor(pessoa.getNome(),
                    pessoa.getDataNascimento(),
                    pessoa.getCpf(),
                    pessoa.getEstadoCivil(),
                    pessoa.getQtdFilhos(),
                    pessoa.getEndereco(),
                    valorSalario,
                    gerarMatricula(),
                    cargo,
                    dataAdmissao);
        }

        System.out.println("Funcionario criado com a matricula: " + funcionario.getMatricula());
        empresa.adicionarFuncionario(funcionario);
    }

    /**
     * Inicia a busca de um funcionário na lista de funcionários da empresa e exibe suas informações.
     */
    private static void buscarFuncionario() {
        System.out.println("Digite a matricula do funcionario: ");
        String mat = scanner.next();

        Funcionario funcionario = empresa.buscarFuncionario(mat);

        if(funcionario != null) {
            System.out.println("Nome: " + ((Pessoa) funcionario).getNome() + " | Cargo: " + funcionario.getCargo());
        }
    }

    /**
     * Realiza a demicao de um funcionário da empresa e calcula o valor de sua recisão.
     */
    private static void demitirFuncionario() {
        System.out.println("Digite a matricula do funcionario: ");
        String mat = scanner.next();
        float recisao = empresa.demitirFuncionario(mat);

        System.out.println("O funcionario de matricula " + mat + " foi demitido. Valor de sua recisão: " + recisao);
    }

    /**
     * Gerar o arquivo de folha de pagamento no diretório de Downloads.
     */
    public static void gerarFolhaDePagamento() {
        System.out.println("Recolhendo informacoes da folha de pagamento...");
        empresa.gerarFolhaDePagamento();

        System.out.println("Arquivo salvo no diretório de Downloads com sucesso!");
    }
}
        

