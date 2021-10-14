package br.com.filipemot.adapter.classes;

import br.com.filipemot.adapter.interfaces.ProcessorPagamento2;

public class MeuPagamentoCredito3 extends SdkPagamentoCredito3 implements ProcessorPagamento2  {
    public void debitar(float valor){
        super.autorizar(valor);
        super.capturar(valor);
    }

    public void creditar(float valor){
        super.creditar(valor);
    }
}
