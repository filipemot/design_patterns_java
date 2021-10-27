package br.com.filipemot.decorator.classes;

import br.com.filipemot.decorator.interfaces.IEnderecador;

//Decorator - Acrescenta funcionalidades
public class EnderecadorCaixaAlta2 implements IEnderecador {
    EnderecadorSimples enderecadorSimples;

    public EnderecadorCaixaAlta2(EnderecadorSimples enderecadorSimples){
        super();
        this.enderecadorSimples = enderecadorSimples;
    }

    public String preparaEndereco(Endereco endereco){
        return enderecadorSimples.preparaEndereco(endereco).toUpperCase();
    }
}
