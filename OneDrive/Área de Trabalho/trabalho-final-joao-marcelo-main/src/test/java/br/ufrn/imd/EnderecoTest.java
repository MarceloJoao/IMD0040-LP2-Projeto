package br.ufrn.imd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para a classe Endereco.
 * Verifica se os getters, setters e o método toString estão funcionando como esperado.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class EnderecoTest {
    /**
     * Testa a criação de um Endereco e verifica se os getters retornam os valores corretos.
     */
    @Test
    public void testEndereco() {
        Endereco endereco = new Endereco("Rua Um", "Bairro Um", "Cidade Um", 1);

        assertEquals("Rua Um", endereco.getRua());
        assertEquals("Bairro Um", endereco.getBairro());
        assertEquals("Cidade Um", endereco.getCidade());
        assertEquals(1, endereco.getNumero());

        endereco.setRua("Rua Dois");
        endereco.setBairro("Bairro Dois");
        endereco.setCidade("Cidade Dois");
        endereco.setNumero(2);

        assertEquals("Rua Dois", endereco.getRua());
        assertEquals("Bairro Dois", endereco.getBairro());
        assertEquals("Cidade Dois", endereco.getCidade());
        assertEquals(2, endereco.getNumero());
    }

    /**
     * Testa o metodo toString de um Endereco e verifica se ele retorna o valor correto.
     */
    @Test
    public void testToString() {
        Endereco endereco = new Endereco("Rua generica", "Centro", "Cidade Comum", 123);
        String expected = "Rua generica, Centro - Cidade Comum, N°123";

        assertEquals(expected, endereco.toString());
    }
}
