package br.com.filipemot.adapter.classes;

import br.com.filipemot.adapter.interfaces.ProcessorPagamento2;

public class MeuPagamentoCredito2 implements ProcessorPagamento2 {
    SdkPagamentoCredito sdkPagamentoCredito = new SdkPagamentoCredito();
    public void debitar(float valor){
        sdkPagamentoCredito.autorizar(valor);
        sdkPagamentoCredito.capturar(valor);
    }

    public void creditar(float valor){
        sdkPagamentoCredito.creditar(valor);
    }
}
