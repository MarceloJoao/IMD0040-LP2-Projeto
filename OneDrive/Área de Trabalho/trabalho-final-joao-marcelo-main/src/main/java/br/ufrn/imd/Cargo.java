package br.ufrn.imd;

/**
 * Enum dos cargos disponíveis na empresa, cada um com um bônus associado.
 * O bônus é uma porcentagem que representa um adicional ao salário base do cargo.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public enum Cargo {
    ASG(0.05f), VENDEDOR_A(0.10f), VENDEDOR_B(0.15f), VENDEDOR_C(0.20f), GERENTE(0.0f);

    private final float bonus;

    /**
     * Construtor privado para definir o bônus de cada cargo.
     *
     * @param bonus O valor do bônus como uma fração decimal.
     */
    Cargo(float bonus) {
        this.bonus = bonus;
    }

    /**
     * Retorna o bônus associado ao cargo.
     *
     * @return O valor do bônus.
     */
    public float getBonus() {
        return this.bonus;
    }
}
