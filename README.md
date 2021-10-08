
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