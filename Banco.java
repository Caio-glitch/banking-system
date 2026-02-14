package banco;
import banco.Conta;
import java.util.ArrayList;


public class Banco {

    private ArrayList<Conta> contas = new ArrayList<>();

    public void cadastrarConta(String nome, String cpf, String senha) {
        Conta conta = new Conta(nome, cpf, senha);
        contas.add(conta);
        System.out.println("Conta criada com sucesso!");
        System.out.println("Número da conta: " + conta.getNumeroConta());
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta c : contas) {
            if (c.getNumeroConta() == numeroConta) {
                return c;
            }
        }
        return null;
    }
}
