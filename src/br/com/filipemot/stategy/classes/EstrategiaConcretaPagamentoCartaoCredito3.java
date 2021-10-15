package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento3;
import br.com.filipemot.stategy.interfaces.Pagavel3;

public class EstrategiaConcretaPagamentoCartaoCredito3 implements EstrategiaPagamento3 {

    @Override
    public void pagar(Pagavel3 compra) {
        System.out.println(compra.getValor());
    }
}
