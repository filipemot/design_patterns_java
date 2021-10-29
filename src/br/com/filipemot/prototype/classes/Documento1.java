package br.com.filipemot.prototype.classes;

public class Documento1 implements Cloneable{
    String nome;
    String visibilidade;
    String tipo;
    String localizacao;

    @Override
    protected Documento1 clone() throws CloneNotSupportedException {
        return (Documento1)super.clone();
    }

    @Override
    public String toString() {
        return "Documento1{" +
                "nome='" + nome + '\'' +
                ", visibilidade='" + visibilidade + '\'' +
                ", tipo='" + tipo + '\'' +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
