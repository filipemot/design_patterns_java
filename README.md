
# Design Patterns em Java


# Padrão Factory

Não precisa ter construtores para obter uma instância de um Objeto. Por padrão, basicamente temos a implementação baseado em três estrututas:

-   Abstrato: Contrato do Objeto que pode ser uma interface ou uma classe abstrata

-   Concreto: Implementação do Objeto

-   Criador: Criadores de Novos Objetos

    ```java
    public interface ProdutoAbstrato {
    }
    
    public class ProdutoConcreto implements ProdutoAbstrato {
    }
    
    public class ProdutoConcretoNovaImplementacao implements ProdutoAbstrato {
    }
    
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
    
    ```


**Static Factory**

Construtores de Objetos estáticos. Retornam instâncias de Objetos, sem precisar conhecer sua essência

**Exemplos**

-   Calendar.getInstance()
-   NumberFormat.getInstance()
-   Stream.of(1,2,3,4)
-   Integer.valueOf("1234")


# Padrão Adapter  

Quando as vezes não temos acesso a uma implementação de uma classe que precisamos utilizar, porém não conseguimos alterá-la e adaptá-la para o nosso uso, ficando restrito ao conjunto de métodos disponibilizados por essa classe. Quando acontece isso um padrão que se utiliza bastante é a criação de uma classe que vai fazer as chamadas para essa classe "fechada", sendo assim é possível adaptar a utilização dos métodos de uma classe que não é possível alterar a implementação. No padrão adapter temos 3 nomes que precisamos lembrar:

-   Client - Classe que consome o Adapter
-   Adapter - Classe que faz a adaptação da classe Adaptee
-   Adaptee - Classe "fechada", que temos acesso apenas para consumo dos métodos

```java
class SdkPagamentoCredito {
    public void autorizar(float valor){

    }

    public void capturar(float valor){

    }

    public void creditar(float valor){

    }
}

public class MeuPagamentoCredito {
    SdkPagamentoCredito sdkPagamentoCredito = new SdkPagamentoCredito();
    public void debitar(float valor){
        sdkPagamentoCredito.autorizar(valor);
        sdkPagamentoCredito.capturar(valor);
    }

    public void creditar(float valor){
        sdkPagamentoCredito.creditar(valor);
    }
}

public class Adapter {
    public static void main(String[] args){
        MeuPagamentoCredito meuPagamentoCredito = new MeuPagamentoCredito();
        meuPagamentoCredito.debitar(50);
    }
}

```

Podemos ainda ter o Target que seria a definição de um alvo de implementação, isso acontece normalmente quando temos o uso de alguma interface a ser implementada.

```java
class SdkPagamentoCredito2 {
    public void autorizar(float valor){

    }

    public void capturar(float valor){

    }

    public void creditar(float valor){

    }
}

public class MeuPagamentoCredito2 implements ProcessorPagamento2 {
    SdkPagamentoCredito sdkPagamentoCredito = new SdkPagamentoCredito();
    public void debitar(float valor){
        sdkPagamentoCredito.autorizar(valor);
        sdkPagamentoCredito.capturar(valor);
    }

    public void creditar(float valor){
        sdkPagamentoCredito.creditar(valor);
    }
}

public interface ProcessorPagamento2 {
    void debitar(float valor);

    void creditar(float valor);
}

public class Adapter2 {
    public static void main(String[] args){
        ProcessorPagamento2 meuPagamentoCredito = new MeuPagamentoCredito2();
        meuPagamentoCredito.debitar(50);
    }
}

```

Uma outra prática que utilizamos, é a herança. Isso possibilita criarmos a classe de adptação, ou apenas utilizar a classe do Adaptee.

```java
class SdkPagamentoCredito3 {
    public void autorizar(float valor){

    }

    public void capturar(float valor){

    }

    public void creditar(float valor){

    }
}

public class MeuPagamentoCredito3 extends SdkPagamentoCredito3 implements ProcessorPagamento2  {
    public void debitar(float valor){
        super.autorizar(valor);
        super.capturar(valor);
    }

    public void creditar(float valor){
        super.creditar(valor);
    }
}

public interface ProcessorPagamento2 {
    void debitar(float valor);

    void creditar(float valor);
}

public class Adapter3 {
    public static void main(String[] args){
        ProcessorPagamento2 meuPagamentoCredito = new MeuPagamentoCredito3();
        meuPagamentoCredito.debitar(50);
    }
}

```

# Padrão Strategy

Esse padrão é utilizado para criarmos várias estratégias de implementação, não precisando numa definição de implementação o uso de vários ifs/else. Nesse padrão conseguimos encapsular o comportamento dos "algoritmos".
Quando se refere a esse  padrão precisamos ter em mente 3 nomes

- Estrategia - Interface - Contrato da Estrategia
- Estrategia - Concreta - Implementação da Estrategia
- Contexto - Implementação junto com a estratégia

Podemos implementar esse padrão dessas 3 formas:

**1 - Dados**

```java
package br.com.filipemot.stategy.interfaces;

public interface EstrategiaPagamento {
    void pagar(float valor);
}

package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento;

public class EstrategiaConcretaPagamentoCartaoCredito implements EstrategiaPagamento {

    @Override
    public void pagar(float valor) {
        System.out.println(valor);
    }
}

package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento;

public class EstrategiaConcretaPagamentoCartaoDebito implements EstrategiaPagamento {

    @Override
    public void pagar(float valor) {
        System.out.println(valor);
    }
}

package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento;

public class ContextoCompra {

    float valor;

    public ContextoCompra(float valor){
        this.valor = valor;
    }

    public void processarCompra(EstrategiaPagamento estrategiaPagamento){
        estrategiaPagamento.pagar(valor);
    }
}

package br.com.filipemot.stategy.classes;

public class Strategy {
    public static void main(String[] args){
        ContextoCompra compra = new ContextoCompra(0f);
        compra.processarCompra(new EstrategiaConcretaPagamentoCartaoCredito());
    }
}
```

**2 - Instancia**

```java
package br.com.filipemot.stategy.interfaces;

import br.com.filipemot.stategy.classes.ContextoCompra2;

public interface EstrategiaPagamento2 {
    void pagar(ContextoCompra2 compra);
}

package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento2;

public class ContextoCompra2 {

    float valor;

    public ContextoCompra2(float valor){
        this.valor = valor;
    }

    public void processarCompra(EstrategiaPagamento2 estrategiaPagamento){

        estrategiaPagamento.pagar(this);
    }
}

package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento2;

public class EstrategiaConcretaPagamentoCartaoCredito2 implements EstrategiaPagamento2 {

    @Override
    public void pagar(ContextoCompra2 compra) {
        System.out.println(compra.valor);
    }
}

public class EstrategiaConcretaPagamentoCartaoDebito2 implements EstrategiaPagamento2 {

    @Override
    public void pagar(ContextoCompra2 contextoCompra2) {
        System.out.println(contextoCompra2.valor);
    }
}

package br.com.filipemot.stategy.classes;

public class Strategy2 {
    public static void main(String[] args){
        ContextoCompra2 compra = new ContextoCompra2(0f);
        compra.processarCompra(new EstrategiaConcretaPagamentoCartaoCredito2());
    }
}
```

**3 - Instancia por Interface**

```java
package br.com.filipemot.stategy.interfaces;

public interface Pagavel3 {
    float getValor();
}

package br.com.filipemot.stategy.interfaces;

public interface EstrategiaPagamento3 {
    void pagar(Pagavel3 compra);
}

package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento3;
import br.com.filipemot.stategy.interfaces.Pagavel3;

public class EstrategiaConcretaPagamentoCartaoCredito3 implements EstrategiaPagamento3 {

    @Override
    public void pagar(Pagavel3 compra) {
        System.out.println(compra.getValor());
    }
}

package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento3;
import br.com.filipemot.stategy.interfaces.Pagavel3;

public class EstrategiaConcretaPagamentoCartaoDebito3 implements EstrategiaPagamento3 {

    @Override
    public void pagar(Pagavel3 pagavel3) {
        System.out.println(pagavel3.getValor());
    }
}

package br.com.filipemot.stategy.classes;

import br.com.filipemot.stategy.interfaces.EstrategiaPagamento3;
import br.com.filipemot.stategy.interfaces.Pagavel3;

public class ContextoCompra3 implements Pagavel3 {

    float valor;

    public ContextoCompra3(float valor){
        this.valor = valor;
    }

    public void processarCompra(EstrategiaPagamento3 estrategiaPagamento){

        estrategiaPagamento.pagar(this);
    }

    @Override
    public float getValor() {
        return this.valor;
    }
}

package br.com.filipemot.stategy.classes;

public class Strategy3 {
    public static void main(String[] args){
        ContextoCompra3 compra = new ContextoCompra3(0f);
        compra.processarCompra(new EstrategiaConcretaPagamentoCartaoCredito3());
    }
}
```

# Padrão Singleton

Singleton é ter uma única instância de uma classe na aplicação.

Para a sua aplicação manter uma única instância de uma classe temos algumas maneiras de fazer isso.

**Instância Estática -** Ter uma variável static com a instância da classe.

```java
package br.com.filipemot.singleton.classes;

import br.com.filipemot.singleton.interfaces.Produto4;

public class ProductFactory {
    public static final ProductFactory INSTANCE = new ProductFactory();

    private ProductFactory(){}

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
```

**Instância Lazy -** Ter um método que gerencia a criação da instância da classe

```java
package br.com.filipemot.singleton.classes;

import br.com.filipemot.singleton.interfaces.Produto4;

public class ProductFactoryLazy {
    private static ProductFactoryLazy instance;

    private ProductFactoryLazy(){}

    public static ProductFactoryLazy getInstance(){
        if(instance == null){
            instance = new ProductFactoryLazy();
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
```

**Instância Multithred -** Ter um método que gerencia a criação da instância da classe e sincroniza quando se utiliza em um código multithread.

```java
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
```

**Instância Enum -** Esse é a maneira mais aconselhável de fazer, onde o próprio java gerencia a criação da instância.

```java
package br.com.filipemot.singleton.classes;

import br.com.filipemot.singleton.interfaces.Produto4;

enum ProductFactoryEnum {
INSTANCE;
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

```

Abaixo está a utilização do Singeton para cada tipo.

```java
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

```

# Padrão Proxy

Proxy nada mais é que sobrescrever uma implementação, podendo adicionar mais ações e depois chamara a implementação original ou sobrescrever por inteiro. .
O padrão proxy é formado por 3 partes:

- RealSubject/Implementação
- Proxy
- Subject - Interface

Uma das formas de fazer proxy é com herança.

```java
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

package br.com.filipemot.proxy.classes;

public class ProdutoService {
    private ProdutoDAO produtoDAO;

    public ProdutoService(ProdutoDAO produtoDAO){
        this.produtoDAO = produtoDAO;
    }

    public Object buscarProduto(long id){
        return produtoDAO.find(id);
    }
}

//Proxy
package br.com.filipemot.proxy.classes;

public class LogProdutoDAO extends ProdutoDAO {

    @Override
    public Object find(long id) {
        System.out.println("Log");
        return super.find(id);
    }
}
```

A outra forma é por composição utilizando interface.

```java
package br.com.filipemot.proxy.interfaces;

public interface IProdutoDAO {
    Object find(long id);
}

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

//Proxy
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
```

# Padrão Decorator

Incrementar funcionalidades a uma classe sem uso de herança.

A primeiro tipo de implementação desse padrão é a passagem de Instância de outra classe no construtor.

```java
package br.com.filipemot.decorator.classes;

public class Endereco {
    final String logadouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco(String logadouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logadouro = logadouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

package br.com.filipemot.decorator.classes;

public class EnderecadorSimples {
    public String preparaEndereco(Endereco endereco){
        StringBuilder sb = new StringBuilder();
        sb.append(endereco.logadouro);
        sb.append(endereco.bairro);
        sb.append(endereco.cidade);
        sb.append(endereco.uf);
        sb.append(endereco.cep);

        return sb.toString();
    }
}

package br.com.filipemot.decorator.classes;

//Decorator - Acrescenta funcionalidades
public class EnderecadorCaixaAlta {
    EnderecadorSimples enderecadorSimples;

    public EnderecadorCaixaAlta(EnderecadorSimples enderecadorSimples){
        super();
        this.enderecadorSimples = enderecadorSimples;
    }

    public String preparaEndereco(Endereco endereco){
        return enderecadorSimples.preparaEndereco(endereco).toUpperCase();
    }
}
```

Uma outra forma de trabalhar com esse padrão é utilizando interface.

```java
package br.com.filipemot.decorator.classes;

public class Endereco {
    final String logadouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco(String logadouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logadouro = logadouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

package br.com.filipemot.decorator.interfaces;

import br.com.filipemot.decorator.classes.Endereco;

public interface IEnderecador {
    String preparaEndereco(Endereco endereco);
}

package br.com.filipemot.decorator.classes;

import br.com.filipemot.decorator.interfaces.IEnderecador;

public class EnderecadorSimples2 implements IEnderecador {
    public String preparaEndereco(Endereco endereco){
        StringBuilder sb = new StringBuilder();
        sb.append(endereco.logadouro);
        sb.append(endereco.bairro);
        sb.append(endereco.cidade);
        sb.append(endereco.uf);
        sb.append(endereco.cep);

        return sb.toString();
    }
}

package br.com.filipemot.decorator.classes;

import br.com.filipemot.decorator.interfaces.IEnderecador;

//Decorator - Acrescenta funcionalidades
public class EnderecadorCaixaAlta2 implements IEnderecador {
    EnderecadorSimples enderecadorSimples;

    public EnderecadorCaixaAlta2(EnderecadorSimples enderecadorSimples){
        super();
        this.enderecadorSimples = enderecadorSimples;
    }

    public String preparaEndereco(Endereco endereco){
        return enderecadorSimples.preparaEndereco(endereco).toUpperCase();
    }
}
```

E por ultimo além da Interface, podemos utilizar Classe abstrata.

```java
package br.com.filipemot.decorator.classes;

public class Endereco {
    final String logadouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco(String logadouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logadouro = logadouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

package br.com.filipemot.decorator.interfaces;

import br.com.filipemot.decorator.classes.Endereco;

public interface IEnderecador {
    String preparaEndereco(Endereco endereco);
}

package br.com.filipemot.decorator.classes;

import br.com.filipemot.decorator.interfaces.IEnderecador;

abstract class EnderecadorDecorator implements IEnderecador {
    IEnderecador enderecador;
    public EnderecadorDecorator(IEnderecador enderecador){
        super();
        this.enderecador = enderecador;
    }
}

package br.com.filipemot.decorator.classes;

import br.com.filipemot.decorator.interfaces.IEnderecador;

public class EnderecadorCaixaAlta3 extends EnderecadorDecorator {
    EnderecadorSimples enderecadorSimples;

    public EnderecadorCaixaAlta3(IEnderecador enderecador){
        super(enderecador);
    }

    public String preparaEndereco(Endereco endereco){
        return enderecadorSimples.preparaEndereco(endereco).toUpperCase();
    }
}
```

# Padrão Template Method

Forma diferente de usar herança, mudando o comportamento da classe. Esse padrão obrigatoriamente utilizará herança.
Basicamente ele tem dois tipos de classe a Abstrata e as Concretas.

```java
package br.com.filipemot.templatemethod.classes;

abstract class ProcessadorPagamento {

    //Classe Abstract

    //Template Method
    public void processarPagamento(){
        preparar();
        validar();
        debitar();
        notificar();
        finalizar();
    }

    protected abstract void debitar();

    private void preparar() {
        System.out.println("Pagamento preparado");
    }

    private void validar() {
        System.out.println("Pagamento validado");
    }

    protected void notificar() {
        System.out.println("Pagamento notificado");
    }

    protected void finalizar() {
        System.out.println("Pagamento finalizado");
    }
}

package br.com.filipemot.templatemethod.classes;

public class ProcessadorPagamentoCredito extends ProcessadorPagamento {

    //Classe Concreta
    @Override
    protected void debitar() {
        System.out.print("Debitando credito...");
    }
}
```