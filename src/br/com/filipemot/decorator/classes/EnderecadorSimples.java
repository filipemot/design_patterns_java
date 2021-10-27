package br.com.filipemot.decorator.classes;

public class EnderecadorSimples {
    public String preparaEndereco(Endereco endereco){
        StringBuilder sb = new StringBuilder();
        sb.append(endereco.logadouro);
        sb.append(endereco.bairro);
        sb.append(endereco.cidade);
        sb.append(endereco.uf);
        sb.append(endereco.cep);

        return sb.toString();
    }
}
