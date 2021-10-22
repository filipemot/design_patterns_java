package br.com.filipemot.proxy.classes;

import br.com.filipemot.proxy.interfaces.IProdutoDAO;

public class ProdutoService2 {
    private IProdutoDAO produtoDAO;

    public ProdutoService2(IProdutoDAO produtoDAO){
        this.produtoDAO = produtoDAO;
    }

    public Object buscarProduto(long id){
        return produtoDAO.find(id);
    }
}
