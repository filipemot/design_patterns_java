package br.com.filipemot.proxy.classes;

public class LogProdutoDAO extends ProdutoDAO {

    @Override
    public Object find(long id) {
        System.out.println("Log");
        return super.find(id);
    }
}
