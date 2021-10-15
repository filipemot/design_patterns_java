package br.com.filipemot.stategy.classes;

public class Strategy {
    public static void main(String[] args){
        ContextoCompra compra = new ContextoCompra(0f);
        compra.processarCompra(new EstrategiaConcretaPagamentoCartaoCredito());
    }
}
