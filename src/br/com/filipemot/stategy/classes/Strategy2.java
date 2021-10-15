package br.com.filipemot.stategy.classes;

public class Strategy2 {
    public static void main(String[] args){
        ContextoCompra2 compra = new ContextoCompra2(0f);
        compra.processarCompra(new EstrategiaConcretaPagamentoCartaoCredito2());
    }
}
