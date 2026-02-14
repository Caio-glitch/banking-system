package banco;

public class Conta {

    private static int SEQUENCIAL = 1;

    private int numeroConta;
    private String nome;
    private String cpf;
    private String senha;
    private double saldo;

    public Conta(String nome, String cpf, String senha) {
        this.numeroConta = SEQUENCIAL++;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.saldo = 0.0;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
