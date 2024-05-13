public class Saque {
    private ContaFisica contas;
    private boolean realizado;

    public Saque(ContaFisica conta) {
        this.contas = conta;
        this.realizado = false;
    }

    public void executarSaque(double valor) {
        if (!realizado) {
            if (contas.sacar(valor)) {
                System.out.println("Saque de R$" + valor + " realizado com sucesso!");
                realizado = true;
            } else {
                System.out.println("Não foi possível realizar o saque. Saldo insuficiente.");
            }
        } else {
            System.out.println("Este saque já foi realizado anteriormente.");
        }
    }

