package br.com.filipemot.proxy.classes;

import br.com.filipemot.proxy.interfaces.IProdutoDAO;

public class ProdutoDAO2 implements IProdutoDAO {

    public ProdutoDAO2(){
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
