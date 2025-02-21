package entities;

public class PessoaJuridica extends Contribuinte {
    private int numeroFuncionarios;

    public PessoaJuridica(String nome, double rendaAnual, int numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double calcularImposto() {
        if (numeroFuncionarios > 10) {
            return rendaAnual * 0.14;
        } else {
            return rendaAnual * 0.16;
        }
    }
}