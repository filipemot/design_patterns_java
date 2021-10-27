package br.com.filipemot.decorator.classes;

public class Endereco {
    final String logadouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco(String logadouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logadouro = logadouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}
