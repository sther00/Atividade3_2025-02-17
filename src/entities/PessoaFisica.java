package entities;

public class PessoaFisica extends Contribuinte {
    private double gastosSaude;

    public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double calcularImposto() {
        double imposto = 0;
        if (rendaAnual < 20000) {
            imposto = rendaAnual * 0.15;
        } else {
            imposto = rendaAnual * 0.25;
        }
        imposto -= gastosSaude * 0.5;
        return Math.max(imposto, 0); // Garante que o imposto não seja negativo
    }
}