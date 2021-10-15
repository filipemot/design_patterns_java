package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento2;

public class EstrategiaConcretaPagamentoCartaoDebito2 implements EstrategiaPagamento2 {

    @Override
    public void pagar(ContextoCompra2 contextoCompra2) {
        System.out.println(contextoCompra2.valor);
    }
}
