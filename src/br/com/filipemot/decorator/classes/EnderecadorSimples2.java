package br.com.filipemot.decorator.classes;

import br.com.filipemot.decorator.interfaces.IEnderecador;

public class EnderecadorSimples2 implements IEnderecador {
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
