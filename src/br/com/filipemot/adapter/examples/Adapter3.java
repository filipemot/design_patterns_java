package br.com.filipemot.adapter.examples;

import br.com.filipemot.adapter.classes.MeuPagamentoCredito2;
import br.com.filipemot.adapter.classes.MeuPagamentoCredito3;
import br.com.filipemot.adapter.interfaces.ProcessorPagamento2;

public class Adapter3 {
    public static void main(String[] args){
        ProcessorPagamento2 meuPagamentoCredito = new MeuPagamentoCredito3();
        meuPagamentoCredito.debitar(50);
    }
}
