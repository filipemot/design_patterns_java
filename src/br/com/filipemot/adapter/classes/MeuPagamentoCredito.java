package br.com.filipemot.adapter.classes;

public class MeuPagamentoCredito {
    SdkPagamentoCredito sdkPagamentoCredito = new SdkPagamentoCredito();
    public void debitar(float valor){
        sdkPagamentoCredito.autorizar(valor);
        sdkPagamentoCredito.capturar(valor);
    }

    public void creditar(float valor){
        sdkPagamentoCredito.creditar(valor);
    }
}
