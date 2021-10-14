package br.com.filipemot.adapter.examples;

import br.com.filipemot.adapter.classes.MeuPagamentoCredito2;
import br.com.filipemot.adapter.interfaces.ProcessorPagamento2;

public class Adapter2 {
    public static void main(String[] args){
        ProcessorPagamento2 meuPagamentoCredito = new MeuPagamentoCredito2();
        meuPagamentoCredito.debitar(50);
    }
}
