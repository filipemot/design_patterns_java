package br.com.filipemot.decorator.classes;

import br.com.filipemot.decorator.interfaces.IEnderecador;

abstract class EnderecadorDecorator implements IEnderecador {
    IEnderecador enderecador;
    public EnderecadorDecorator(IEnderecador enderecador){
        super();
        this.enderecador = enderecador;
    }
}
