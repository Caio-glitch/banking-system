package banco;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Login");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF (11 dígitos): ");
                    String cpf = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    if (cpf.length() == 11) {
                        banco.cadastrarConta(nome, cpf, senha);
                    } else {
                        System.out.println("CPF inválido!");
                    }
                }

                case 2 -> {
                    System.out.print("Número da conta: ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    Conta conta = banco.buscarConta(numero);

                    if (conta != null) {
                        System.out.print("Senha: ");
                        String senha = sc.nextLine();

                        if (conta.getSenha().equals(senha)) {
                            menuConta(sc, conta, banco);
                        } else {
                            System.out.println("Senha incorreta!");
                        }
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                }
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void menuConta(Scanner sc, Conta conta, Banco banco) {

        int opcao;

        do {
            System.out.println("\n=== CONTA ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Ver saldo");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    conta.depositar(valor);
                    System.out.println("Depósito realizado!");
                }

                case 2 -> {
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    if (conta.sacar(valor)) {
                        System.out.println("Saque realizado!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                }

                case 3 -> {
                    System.out.print("Conta destino: ");
                    int destinoNumero = sc.nextInt();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();

                    Conta destino = banco.buscarConta(destinoNumero);

                    if (destino != null) {
                        if (conta.transferir(destino, valor)) {
                            System.out.println("Transferência realizada!");
                        } else {
                            System.out.println("Erro na transferência!");
                        }
                    } else {
                        System.out.println("Conta destino não encontrada!");
                    }
                }

                case 4 -> {
                    System.out.println("Saldo atual: " + conta.getSaldo());
                }
            }

        } while (opcao != 0);
    }
}
