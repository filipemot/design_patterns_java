
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

