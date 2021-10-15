package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento3;
import br.com.filipemot.stategy.interfaces.Pagavel3;

public class ContextoCompra3 implements Pagavel3 {

    float valor;

    public ContextoCompra3(float valor){
        this.valor = valor;
    }

    public void processarCompra(EstrategiaPagamento3 estrategiaPagamento){

        estrategiaPagamento.pagar(this);
    }

    @Override
    public float getValor() {
        return this.valor;
    }
}
