package br.com.filipemot.adapter.examples;

import br.com.filipemot.adapter.classes.MeuPagamentoCredito;

public class Adapter {
    public static void main(String[] args){
        MeuPagamentoCredito meuPagamentoCredito = new MeuPagamentoCredito();
        meuPagamentoCredito.debitar(50);
    }
}
