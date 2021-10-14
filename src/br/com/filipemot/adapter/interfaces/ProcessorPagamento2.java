package br.com.filipemot.adapter.interfaces;

public interface ProcessorPagamento2 {
    void debitar(float valor);

    void creditar(float valor);
}
