package br.ufrn.imd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

/**
 * Classe de teste para a classe ASG.
 * Verifica se os metodos calcularSalario e calcularRescisao estão funcionando como esperado.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class ASGTest {
    /**
     * Testa o cálculo do salário do ASG com dois dias de falta.
     * Este teste verifica se o salário calculado está correto após descontar as faltas.
     */
    @Test
    public void testCalcularSalario() {
        Endereco endereco = new Endereco("Rua Um", "Bairro Um", "Cidade Um", 1);
        ASG asg = new ASG("João", LocalDate.of(1990, 1, 1), "123.456.789-00", "Solteiro", 0,
                endereco, 3000.0f, "1234", Cargo.ASG, LocalDate.of(2020, 1, 1));

        float salario = asg.calcularSalario(2);
        assertEquals(2940.0f, salario, 0.01f);
    }

    /**
     * Testa o cálculo da rescisão do ASG.
     * Este teste verifica se o valor da rescisão calculado está correto com base no tempo de serviço.
     */
    @Test
    public void testCalcularRescisao() {
        Endereco endereco = new Endereco("Rua Um", "Bairro Um", "Cidade Um", 1);
        ASG asg = new ASG("João", LocalDate.of(1990, 1, 1), "123.456.789-00", "Solteiro", 0,
                endereco, 3000.0f, "1234", Cargo.ASG, LocalDate.of(2020, 1, 1));

        float rescisao = asg.calcularRescisao(LocalDate.of(2023, 1, 1));
        assertEquals(9008.22f, rescisao, 0.01f);
    }
}
