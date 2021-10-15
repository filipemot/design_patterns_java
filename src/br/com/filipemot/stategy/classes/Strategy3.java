package br.com.filipemot.stategy.classes;

public class Strategy3 {
    public static void main(String[] args){
        ContextoCompra3 compra = new ContextoCompra3(0f);
        compra.processarCompra(new EstrategiaConcretaPagamentoCartaoCredito3());
    }
}
