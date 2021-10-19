package br.com.filipemot.singleton.classes;

import br.com.filipemot.singleton.interfaces.Produto4;

public class ProductFactoryLazyMultihread {
    private static ProductFactoryLazyMultihread instance;

    private ProductFactoryLazyMultihread(){}

    public static synchronized ProductFactoryLazyMultihread getInstance(){
        if(instance == null){
            instance = new ProductFactoryLazyMultihread();
        }

        return instance;
    }

    public Produto4 novoProduto(int tipoProduto){
        switch (tipoProduto) {
            case 1:
                return new ProdutoPadrao4();
            case 2:
                return new ProdutoDigital4();
            case 3:
                return new ProdutoFisico4();
            default:
                throw new IllegalArgumentException();
        }
    }
}
