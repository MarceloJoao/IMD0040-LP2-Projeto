package br.ufrn.imd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para a classe Financas.
 * Verifica se os getters, setters e o construtor estão funcionando como esperado.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class FinancasTest {
    /**
     * Testa a criação de uma Financas e verifica se os getters retornam os valores corretos.
     */
    @Test
    public void testFinancas() {
        Financas financas = new Financas("Razao Social", "Nome Fantasia", "00.000.000/0001-00", 100000.0, 50000.0);

        assertEquals("Razao Social", financas.getRazaoSocial());
        assertEquals("Nome Fantasia", financas.getNomeFantasia());
        assertEquals("00.000.000/0001-00", financas.getCnpj());
        assertEquals(100000.0, financas.getFaturamentoMensal());
        assertEquals(50000.0, financas.getCapital());

        financas.setRazaoSocial("Razao Social Alterada");
        financas.setNomeFantasia("Nome Fantasia Alterado");
        financas.setCnpj("00.000.000/0001-01");
        financas.setFaturamentoMensal(200000.0);
        financas.setCapital(100000.0);

        assertEquals("Razao Social Alterada", financas.getRazaoSocial());
        assertEquals("Nome Fantasia Alterado", financas.getNomeFantasia());
        assertEquals("00.000.000/0001-01", financas.getCnpj());
        assertEquals(200000.0, financas.getFaturamentoMensal());
        assertEquals(100000.0, financas.getCapital());
    }
}
