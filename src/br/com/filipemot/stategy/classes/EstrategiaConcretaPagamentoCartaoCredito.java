package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento;

public class EstrategiaConcretaPagamentoCartaoCredito implements EstrategiaPagamento {

    @Override
    public void pagar(float valor) {
        System.out.println(valor);
    }
}
