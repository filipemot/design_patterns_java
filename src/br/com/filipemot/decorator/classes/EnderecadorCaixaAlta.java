package br.com.filipemot.decorator.classes;

//Decorator - Acrescenta funcionalidades
public class EnderecadorCaixaAlta {
    EnderecadorSimples enderecadorSimples;

    public EnderecadorCaixaAlta(EnderecadorSimples enderecadorSimples){
        super();
        this.enderecadorSimples = enderecadorSimples;
    }

    public String preparaEndereco(Endereco endereco){
        return enderecadorSimples.preparaEndereco(endereco).toUpperCase();
    }
}
