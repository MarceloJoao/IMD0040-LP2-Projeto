package br.ufrn.imd;

/**
 * Classe que representa um endereço comercial ou residencial.
 *
 * @author José Manoel Freitas da Silva
 * @author João Marcelo de Souza
 */
public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private int numero;

    /**
     * Construtor para criar um novo endereço.
     *
     * @param rua A rua do endereço.
     * @param bairro O bairro do endereço.
     * @param cidade A cidade do endereço.
     * @param numero O número da residência ou estabelecimento.
     */
    public Endereco(String rua, String bairro, String cidade, int numero){
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
    }

    /**
     * Retorna a rua do endereço.
     * @return A rua do endereço.
     */
    public String getRua(){
        return this.rua;
    }

    /**
     * Define a rua do endereço.
     * @param rua A nova rua do endereço.
     */
    public void setRua(String rua){
        this.rua = rua;
    }

    /**
     * Retorna o bairro do endereço.
     * @return O bairro do endereço.
     */
    public String getBairro(){
        return this.bairro;
    }

    /**
     * Define o bairro do endereço.
     * @param bairro O novo bairro do endereço.
     */
    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    /**
     * Retorna a cidade do endereço.
     * @return A cidade do endereço.
     */
    public String getCidade(){
        return this.cidade;
    }

    /**
     * Define a cidade do endereço.
     * @param cidade A nova cidade do endereço.
     */
    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    /**
     * Retora o número do endereço.
     * @return O número do endereço.
     */
    public int getNumero(){
        return this.numero;
    }

    /**
     * Define o número do endereço.
     * @param numero O novo número do endereço.
     */
    public void setNumero(int numero){
        this.numero = numero;
    }

    /**
     * Retorna uma representação textual do endereço.
     * @return Uma string formatada com os dados do endereço.
     */
    @Override
    public String toString(){
        return this.rua + ", " + this.bairro + " - " + this.cidade + ", N°" + this.numero;
    }
}
