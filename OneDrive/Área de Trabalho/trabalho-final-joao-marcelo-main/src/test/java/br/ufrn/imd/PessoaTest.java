package br.ufrn.imd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

/**
 * Classe de teste para a classe Pessoa.
 * Verifica se os getters, setters e o construtor estão funcionando como esperado.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class PessoaTest {
    /**
     * Testa a criação de uma Pessoa e verifica se os getters retornam os valores corretos.
     */
    @Test
    public void testPessoa() {
        Endereco endereco = new Endereco("Rua Um", "Centro", "Natal", 123);
        Pessoa pessoa = new Pessoa("João", LocalDate.of(1990, 1, 1), "123.456.789-00", "solteiro", 0, endereco);

        assertEquals("João", pessoa.getNome());
        assertEquals(LocalDate.of(1990, 1, 1), pessoa.getDataNascimento());
        assertEquals("123.456.789-00", pessoa.getCpf());
        assertEquals("solteiro", pessoa.getEstadoCivil());
        assertEquals(0, pessoa.getQtdFilhos());
        assertEquals(endereco, pessoa.getEndereco());

        pessoa.setNome("Maria");
        pessoa.setDataNascimento(LocalDate.of(1995, 1, 1));
        pessoa.setCpf("987.654.321-00");
        pessoa.setEstadoCivil("casado");
        pessoa.setQtdFilhos(1);
        Endereco novoEndereco = new Endereco("Rua Dois", "Lagoa Nova", "Parnamirim", 456);
        pessoa.setEndereco(novoEndereco);

        assertEquals("Maria", pessoa.getNome());
        assertEquals(LocalDate.of(1995, 1, 1), pessoa.getDataNascimento());
        assertEquals("987.654.321-00", pessoa.getCpf());
        assertEquals("casado", pessoa.getEstadoCivil());
        assertEquals(1, pessoa.getQtdFilhos());
        assertEquals(novoEndereco, pessoa.getEndereco());
    }
}
