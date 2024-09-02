package br.ufrn.imd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

/**
 * Classe de teste para a classe Negocio.
 * Verifica se os getters, setters e o construtor estão funcionando como esperado.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class NegocioTest {
    /**
     * Testa a criação de um negocio e verifica se os getters retornam os valores corretos.
     */
    @Test
    public void testNegocio() {
        Endereco endereco = new Endereco("Rua Um", "Centro", "Natal", 123);
        Pessoa proprietario = new Pessoa("João", LocalDate.of(1990, 1, 1), "123.456.789-00", "solteiro", 0, endereco);
        LocalDate dataAbertura = LocalDate.of(2020, 1, 1);

        Negocio negocio = new Negocio("Negocio Generico S/A", "Generico's", "123.456.789/0001-00", dataAbertura, proprietario, endereco, 1000.0, 100.0);

          assertEquals("Negocio Generico S/A", negocio.getRazaoSocial());
          assertEquals("Generico's", negocio.getNomeFantasia());
          assertEquals("123.456.789/0001-00", negocio.getCnpj());
          assertEquals(dataAbertura, negocio.getDataAbertura());
          assertEquals(proprietario, negocio.getProprietario());
          assertEquals(endereco, negocio.getEndereco());
          assertEquals(1000.0, negocio.getFaturamentoMensal());
          assertEquals(100.0, negocio.getCapitalInicial());

          Endereco novoEndereco = new Endereco("Rua Dois", "Lagoa Nova", "Parnamirim", 456);
          Pessoa novoProprietario = new Pessoa("Maria", LocalDate.of(1995, 1, 1), "987.654.321-00", "casado", 1, novoEndereco);
          LocalDate novaDataAbertura = LocalDate.of(2021, 1, 1);

          negocio.setRazaoSocial("Negocio Generico LTDA");
          negocio.setNomeFantasia("Big Generico");
          negocio.setCnpj("987.654.321/0001-00");
          negocio.setDataAbertura(novaDataAbertura);
          negocio.setProprietario(novoProprietario);
          negocio.setEndereco(novoEndereco);
          negocio.setFaturamentoMensal(2000.0);
          negocio.setCapitalInicial(200.0);

          assertEquals("Negocio Generico LTDA", negocio.getRazaoSocial());
          assertEquals("Big Generico", negocio.getNomeFantasia());
          assertEquals("987.654.321/0001-00", negocio.getCnpj());
          assertEquals(novaDataAbertura, negocio.getDataAbertura());
          assertEquals(novoProprietario, negocio.getProprietario());
          assertEquals(novoEndereco, negocio.getEndereco());
          assertEquals(2000.0, negocio.getFaturamentoMensal());
          assertEquals(200.0, negocio.getCapitalInicial());

    }
}
