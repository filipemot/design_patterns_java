package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento2;

public class EstrategiaConcretaPagamentoCartaoCredito2 implements EstrategiaPagamento2 {

    @Override
    public void pagar(ContextoCompra2 compra) {
        System.out.println(compra.valor);
    }
}
