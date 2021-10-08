package br.com.filipemot.factory.examples;

import br.com.filipemot.factory.classes.ProdutoConcreto;
import br.com.filipemot.factory.classes.ProdutoCriador;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.stream.Stream;

public class FactoryObjects {
    public static void main(String[] args){
        ProdutoConcreto produtoConcreto = (ProdutoConcreto) new ProdutoCriador().novoProduto();
        System.out.println(produtoConcreto);
    }
}
