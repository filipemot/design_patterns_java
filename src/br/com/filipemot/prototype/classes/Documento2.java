package br.com.filipemot.prototype.classes;

final class Documento2 implements Cloneable{
    String nome;
    String visibilidade;
    String tipo;
    String localizacao;

    @Override
    protected Documento2 clone() throws CloneNotSupportedException {
        return (Documento2)super.clone();
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
