
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

