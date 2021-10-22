package br.com.filipemot.proxy.classes;

public class ProdutoDAO {

    public ProdutoDAO(){
        simulaTempoAlto();
    }

    private void simulaTempoAlto() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Object find(long id) {
        simulaTempoAlto();
        return new Object();
    }
}
