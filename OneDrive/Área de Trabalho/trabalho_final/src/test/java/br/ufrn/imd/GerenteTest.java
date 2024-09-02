package br.ufrn.imd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;


/**
 * Classe de teste para a classe Gerente.
 * Verifica se os metodos calcularSalario e calcularRescisao estão funcionando como esperado.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class GerenteTest {
    /**
     * Testa o cálculo do salário do Gerente com dois dias de falta.
     * Este teste verifica se o salário calculado está correto após descontar as faltas.
     */
    @Test
    public void testCalcularSalario() {
        Endereco endereco = new Endereco("Rua Um", "Bairro Um", "Cidade Um", 1);
        Gerente gerente = new Gerente("João", LocalDate.of(1980, 1, 1), "123.456.789-00", "Casado", 2, endereco,
                3000.0f, 1000.0f, "1234", Cargo.GERENTE, LocalDate.of(2000, 1, 1));

        float salario = gerente.calcularSalario(2);
        assertEquals(3800.0f, salario, 0.01f);
    }

    /**
     * Testa o cálculo da rescisão do Gerente.
     * Este teste verifica se o valor da rescisão calculado está correto com base no tempo de serviço.
     */
    @Test
    public void testCalcularRescisao() {
        Endereco endereco = new Endereco("Rua Um", "Bairro Um", "Cidade Um", 1);
        Gerente gerente = new Gerente("João", LocalDate.of(1980, 1, 1), "123.456.789-00", "Casado", 2, endereco,
                3000.0f, 1000.0f, "1234", Cargo.GERENTE, LocalDate.of(2020, 1, 1));

        float rescisao = gerente.calcularRescisao(LocalDate.of(2023, 1, 1));
        assertEquals(12010.95f, rescisao, 0.01f);
    }
}


