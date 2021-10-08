package br.com.filipemot.factory.classes;

import br.com.filipemot.factory.interfaces.ProdutoAbstrato;

public class ProdutoCriador {
    public ProdutoAbstrato novoProduto(){
        return new ProdutoConcreto();
    }

    public ProdutoAbstrato novoProduto(int tipoProduto){
        if(tipoProduto == 0) {
            return new ProdutoConcreto();
        } else {
            return new ProdutoConcretoNovaImplementacao();
        }
    }
}
