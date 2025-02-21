package application;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.Scanner;

public class CalculoImposto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tax payers: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Contribuinte[] contribuintes = new Contribuinte[N];
        double totalImposto = 0;

        for (int i = 0; i < N; i++) {
            System.out.println("Tax payer #" + (i + 1) + " data:");
            System.out.print("Individual or company (i/c)? ");
            String tipo = scanner.nextLine();

            System.out.print("Name: ");
            String nome = scanner.nextLine();

            System.out.print("Anual income: ");
            double rendaAnual = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha

            if (tipo.equalsIgnoreCase("i")) {
                System.out.print("Health expenditures: ");
                double gastosSaude = scanner.nextDouble();
                scanner.nextLine(); // Consumir a nova linha
                contribuintes[i] = new PessoaFisica(nome, rendaAnual, gastosSaude);
            } else if (tipo.equalsIgnoreCase("c")) {
                System.out.print("Number of employees: ");
                int numeroFuncionarios = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                contribuintes[i] = new PessoaJuridica(nome, rendaAnual, numeroFuncionarios);
            } else {
                System.out.println("Invalid type. Try again.");
                i--; // Repetir a iteração
            }
        }

        System.out.println("\nTAXES PAID:");
        for (Contribuinte contribuinte : contribuintes) {
            double imposto = contribuinte.calcularImposto();
            System.out.printf("%s: $ %.2f%n", contribuinte.nome, imposto);
            totalImposto += imposto;
        }

        System.out.printf("\nTOTAL TAXES: $ %.2f%n", totalImposto);

        scanner.close();
    }
}
