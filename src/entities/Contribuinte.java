package entities;

public abstract class Contribuinte {
    public String nome;
    protected double rendaAnual;

    public Contribuinte(String nome, double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public abstract double calcularImposto();
}

