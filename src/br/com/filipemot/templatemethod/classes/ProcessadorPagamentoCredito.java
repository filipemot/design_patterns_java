package br.com.filipemot.templatemethod.classes;

public class ProcessadorPagamentoCredito extends ProcessadorPagamento {

    //Classe Concreta
    @Override
    protected void debitar() {
        System.out.print("Debitando credito...");
    }
}
