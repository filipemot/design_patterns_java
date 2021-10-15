package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento;

public class ContextoCompra {

    float valor;

    public ContextoCompra(float valor){
        this.valor = valor;
    }

    public void processarCompra(EstrategiaPagamento estrategiaPagamento){
        estrategiaPagamento.pagar(valor);
    }
}
