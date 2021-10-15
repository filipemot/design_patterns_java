package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento2;

public class ContextoCompra2 {

    float valor;

    public ContextoCompra2(float valor){
        this.valor = valor;
    }

    public void processarCompra(EstrategiaPagamento2 estrategiaPagamento){

        estrategiaPagamento.pagar(this);
    }
}
