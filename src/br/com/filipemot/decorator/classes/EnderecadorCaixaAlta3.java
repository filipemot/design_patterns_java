package br.com.filipemot.decorator.classes;

import br.com.filipemot.decorator.interfaces.IEnderecador;

public class EnderecadorCaixaAlta3 extends EnderecadorDecorator {
    EnderecadorSimples enderecadorSimples;

    public EnderecadorCaixaAlta3(IEnderecador enderecador){
        super(enderecador);
    }

    public String preparaEndereco(Endereco endereco){
        return enderecadorSimples.preparaEndereco(endereco).toUpperCase();
    }
}
