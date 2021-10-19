package br.com.filipemot.singleton.classes;

public class ProductSingleton {
    public static void main(String args[]){
        ProductFactory.INSTANCE.novoProduto(0);
        ProductFactory.INSTANCE.novoProduto(1);
        ProductFactory.INSTANCE.novoProduto(2);

        ProductFactoryLazy.getInstance().novoProduto(0);
        ProductFactoryLazy.getInstance().novoProduto(1);
        ProductFactoryLazy.getInstance().novoProduto(2);

        ProductFactoryEnum.INSTANCE.novoProduto(0);
        ProductFactoryEnum.INSTANCE.novoProduto(1);
        ProductFactoryEnum.INSTANCE.novoProduto(2);
    }
}
