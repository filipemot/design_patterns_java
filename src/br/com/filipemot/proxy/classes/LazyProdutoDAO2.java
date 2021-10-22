package br.com.filipemot.proxy.classes;

import br.com.filipemot.proxy.interfaces.IProdutoDAO;

public class LazyProdutoDAO2 implements IProdutoDAO {

    private IProdutoDAO daoReal;

    public LazyProdutoDAO2(){

    }

    private void inicializaDAO() {
        if(daoReal == null){
            daoReal = new ProdutoDAO2();
        }
    }

    @Override
    public Object find(long id) {
        inicializaDAO();

        return daoReal.find(id);
    }
}
