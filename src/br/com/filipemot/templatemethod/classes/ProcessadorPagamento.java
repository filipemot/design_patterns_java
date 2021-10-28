package br.com.filipemot.templatemethod.classes;

abstract class ProcessadorPagamento {

    //Classe Abstract

    //Template Method
    public void processarPagamento(){
        preparar();
        validar();
        debitar();
        notificar();
        finalizar();
    }

    protected abstract void debitar();

    private void preparar() {
        System.out.println("Pagamento preparado");
    }

    private void validar() {
        System.out.println("Pagamento validado");
    }

    protected void notificar() {
        System.out.println("Pagamento notificado");
    }

    protected void finalizar() {
        System.out.println("Pagamento finalizado");
    }
}
